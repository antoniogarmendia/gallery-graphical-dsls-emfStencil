/**
 */
package cloudRobotics;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cloudRobotics.ConfigurationSystem#getMachines <em>Machines</em>}</li>
 *   <li>{@link cloudRobotics.ConfigurationSystem#getConnections <em>Connections</em>}</li>
 *   <li>{@link cloudRobotics.ConfigurationSystem#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see cloudRobotics.cloudRoboticsPackage#getConfigurationSystem()
 * @model
 * @generated
 */
public interface ConfigurationSystem extends EObject {
	/**
	 * Returns the value of the '<em><b>Machines</b></em>' containment reference list.
	 * The list contents are of type {@link cloudRobotics.VirtualMachine}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Machines</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Machines</em>' containment reference list.
	 * @see cloudRobotics.cloudRoboticsPackage#getConfigurationSystem_Machines()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<VirtualMachine> getMachines();

	/**
	 * Returns the value of the '<em><b>Connections</b></em>' containment reference list.
	 * The list contents are of type {@link cloudRobotics.ConnectionComponent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connections</em>' containment reference list.
	 * @see cloudRobotics.cloudRoboticsPackage#getConfigurationSystem_Connections()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ConnectionComponent> getConnections();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see cloudRobotics.cloudRoboticsPackage#getConfigurationSystem_Name()
	 * @model default=""
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link cloudRobotics.ConfigurationSystem#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // ConfigurationSystem
