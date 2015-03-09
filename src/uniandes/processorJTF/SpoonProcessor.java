package uniandes.processorJTF;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import generated.And;
import generated.FeatureModel;
import generated.ObjectFactory;
import generated.Or;
import generated.Struct;
import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtAnnotation;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtConstructor;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtMethod;
import spoon.support.reflect.code.CtNewClassImpl;
import spoon.support.reflect.declaration.CtClassImpl;
import uniandes.cupi2.numeroMvc.interfaz.InterfazNumeroMvc;
import annotation.Feature;

import javax.xml.bind.annotation.XmlAccessType;

import org.eclipse.jdt.core.dom.AnonymousClassDeclaration;

public class SpoonProcessor extends AbstractProcessor<CtElement> {

	TreeNode tree;
	Node node;
	String actualElement = "actualElement";
	String auxElement = "auxElement";

	@Override
	public void init() {
		tree = new TreeNode();
		tree.setNode("XX", NodeType.Root, true);
		super.init();
		System.out.println("init()");
	}

	@Override
	public void process(CtElement element) {

		/*if (isChildClass(element)) {
			System.out.println("\t\t\t" + getName(element));
		}*/

		if (isClass(element) && getType(element) != NodeType.Root) {
			actualElement = getName(element);
			if (!actualElement.equals(auxElement)) {
				node = new Node();
				node.setNode(actualElement, getType(element), true);
				tree.AddNode(node);
				auxElement = actualElement;
				System.out.println(actualElement);
			}
		}

		if (isClass(element) && getType(element) == NodeType.Root) {
			tree.setName(getName(element));
			System.out.println("Root : " + getName(element));
		}

		if (isMethod(element)) {
			INode childNode = new Node();
			String name = actualElement + "." + getName(element);
			childNode.setNode(name, getType(element), true);
			node.AddNode(childNode);
			System.out.println("\t\t" + name);
		}
	}

	private NodeType getType(CtElement element) {
		NodeType type = NodeType.And;
		if (!element.getAnnotations().isEmpty()) {
			CtAnnotation annotation = (CtAnnotation) element.getAnnotations()
					.toArray()[0];
			if (annotation.getSignature().contains("Root")) {
				type = NodeType.Root;
			}
			if (annotation.getSignature().contains("Or")) {
				type = NodeType.Or;
			}
			if (annotation.getSignature().contains("And")) {
				type = NodeType.And;
			}
		}
		return type;
	}

	private boolean isChildClass(CtElement element) {
		boolean result = false;
		if (element instanceof CtNewClassImpl
				&& element.getSignature().contains("uniandes")) {
			result = true;
		}
		return result;
	}

	private boolean isClass(CtElement element) {
		boolean result = false;
		if (element instanceof CtClass
				&& element.getSignature().contains("uniandes")) {
			result = true;
		}
		return result;
	}

	private boolean isMethod(CtElement element) {
		boolean result = false;
		if (element instanceof CtMethod) {
			result = true;
		}
		return result;
	}

	private String getName(CtElement element) {
		String name = "";
		if (element.getSignature().contains("uniandes")
				|| element instanceof CtMethod) {
			name = element.getSignature().trim().replace("  ", " ")
					.replace("\t", " ").replace("#", "").replace("$", "")
					.replace("new ", " ").replace(" ", "_").replace(")", "]")
					.replace("(", "[")
					.replace("uniandes.cupi2.numeroMvc.", "app.");
			name = name.substring(name.indexOf("_") + 1, name.length());
			if (name.contains("_")) {
				name = name.substring(0, name.indexOf("_"));
			}
		}
		return name;
	}

	@Override
	public void processingDone() {
		JAXBE jaxbe = new JAXBE();
		jaxbe.Serialize(tree.getNode(), "./resources/model.xml",
				"./resources/featureide.xsd");
		super.processingDone();
	}

}
