package uniandes.processorJTF;

import java.util.UUID;

import generated.*;

;
public class Node implements INode {

	private ObjectFactory factory;
	private Parent node;
	private String name;

	public Node() {
		factory = new ObjectFactory();
		this.name = UUID.randomUUID().toString();
	}

	@Override
	public void setNode(String name, NodeType type, boolean required) {
		switch (type) {
		case And:
			node = factory.createAnd();
			((And) node).setMandatory(required);
			break;
		case Or:
			node = factory.createOr();
			((Or) node).setMandatory(required);
			break;
		default:
			node = factory.createOr();
			((Or) node).setMandatory(required);
			break;
		}
		node.setName(name);
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
		node.setName(name);
	}

	@Override
	public Object getNode() {
		return node;
	}

	@Override
	public void AddNode(INode node) {
		this.node.getAndOrAltOrOr().add(node.getNode());
	}
}
