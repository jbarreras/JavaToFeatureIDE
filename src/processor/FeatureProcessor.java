package processor;

import generated.And;
import generated.FeatureModel;
import generated.ObjectFactory;
import generated.Struct;

import java.io.FileWriter;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtAnnotation;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtConstructor;
import annotation.Feature;

public class FeatureProcessor extends AbstractProcessor<CtAnnotation<Feature>> {
	FeatureModel fm;

	@Override
	public void init() {
		ObjectFactory factory = new ObjectFactory();
		fm = factory.createFeatureModel();
		Struct struct = factory.createStruct();

		And root = factory.createAnd();
		root.setName("Biblioteca");
		struct.setAnd(root);
		fm.setStruct(struct);
		// TODO Auto-generated method stub
		super.init();
	}

	@Override
	public void process(CtAnnotation<Feature> annotation) {
		if (annotation.getParent() instanceof CtClass)
			System.out.println("Class Found "
					+ annotation.getParent().getSignature());
		else if (annotation.getParent() instanceof CtConstructor)
			System.out.println("Constructor Found "
					+ annotation.getParent().getSignature());
	}

	@Override
	public void processingDone() {
		// TODO Auto-generated method stub
		jaxbWriter(fm, "./resources/model.xml", "./resources/featureide.xsd");
		super.processingDone();
	}

	/**
	 * Writes the contents of a JAXB model in an xml file with identation and
	 * blank spaces
	 * 
	 * @param root
	 *            the root of the object to write
	 * @param path
	 *            destination of the file to create
	 */
	private void jaxbWriter(Object root, String path, String schema) {
		try {
			JAXBContext context = JAXBContext.newInstance(root.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, schema);
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
					Boolean.TRUE);
			marshaller.marshal(root, new FileWriter(path));
		} catch (JAXBException e) {
			System.err
					.println("Error while preparing to write the JAXB model in: "
							+ path);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error while writting the JAXB model in: "
					+ path);
			e.printStackTrace();
		}
	}
}
