package uniandes.processorJTF;

public interface INode {

	public void setNode(String name, NodeType type, boolean required);

	public String getName();

	public void setName(String name);

	public Object getNode();

	public void AddNode(INode node);
}
