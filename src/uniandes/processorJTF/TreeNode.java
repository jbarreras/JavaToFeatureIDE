package uniandes.processorJTF;

import generated.And;
import generated.FeatureModel;
import generated.ObjectFactory;
import generated.Or;
import generated.Struct;

public class TreeNode implements INode {

	private ObjectFactory factory;
	private FeatureModel model;
	private Struct node0;
	private And node1;
	private String name;

	@Override
	public void setNode(String name, NodeType type, boolean required) {
		factory = new ObjectFactory();
		model = factory.createFeatureModel();
		node1 = factory.createAnd();
		node1.setName(name);
		node0 = factory.createStruct();
		node0.setAnd(node1);
		model.setStruct(node0);
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
		node1.setName(name);
	}

	@Override
	public Object getNode() {
		return model;
	}

	@Override
	public void AddNode(INode node) {
		node1.getAndOrAltOrOr().add(node.getNode());
	}
}
