/**
 */
package cloudRobotics;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Architecture Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cloudRobotics.ArchitectureSpecification#getRobots <em>Robots</em>}</li>
 *   <li>{@link cloudRobotics.ArchitectureSpecification#getRoles <em>Roles</em>}</li>
 *   <li>{@link cloudRobotics.ArchitectureSpecification#getName <em>Name</em>}</li>
 *   <li>{@link cloudRobotics.ArchitectureSpecification#getConnections <em>Connections</em>}</li>
 * </ul>
 *
 * @see cloudRobotics.cloudRoboticsPackage#getArchitectureSpecification()
 * @model
 * @generated
 */
public interface ArchitectureSpecification extends EObject {
	/**
	 * Returns the value of the '<em><b>Robots</b></em>' containment reference list.
	 * The list contents are of type {@link cloudRobotics.Robot}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Robots</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Robots</em>' containment reference list.
	 * @see cloudRobotics.cloudRoboticsPackage#getArchitectureSpecification_Robots()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Robot> getRobots();

	/**
	 * Returns the value of the '<em><b>Roles</b></em>' containment reference list.
	 * The list contents are of type {@link cloudRobotics.Role}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Roles</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Roles</em>' containment reference list.
	 * @see cloudRobotics.cloudRoboticsPackage#getArchitectureSpecification_Roles()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Role> getRoles();

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
	 * @see cloudRobotics.cloudRoboticsPackage#getArchitectureSpecification_Name()
	 * @model default=""
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link cloudRobotics.ArchitectureSpecification#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Connections</b></em>' containment reference list.
	 * The list contents are of type {@link cloudRobotics.ConnectionElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connections</em>' containment reference list.
	 * @see cloudRobotics.cloudRoboticsPackage#getArchitectureSpecification_Connections()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ConnectionElement> getConnections();

} // ArchitectureSpecification
