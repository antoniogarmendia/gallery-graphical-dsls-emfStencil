/**
 */
package cloudRobotics;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cloud System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cloudRobotics.CloudSystem#getName <em>Name</em>}</li>
 *   <li>{@link cloudRobotics.CloudSystem#getArq <em>Arq</em>}</li>
 *   <li>{@link cloudRobotics.CloudSystem#getConfigs <em>Configs</em>}</li>
 * </ul>
 *
 * @see cloudRobotics.cloudRoboticsPackage#getCloudSystem()
 * @model
 * @generated
 */
public interface CloudSystem extends EObject {
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
	 * @see cloudRobotics.cloudRoboticsPackage#getCloudSystem_Name()
	 * @model default=""
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link cloudRobotics.CloudSystem#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Arq</b></em>' containment reference list.
	 * The list contents are of type {@link cloudRobotics.ArchitectureSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arq</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arq</em>' containment reference list.
	 * @see cloudRobotics.cloudRoboticsPackage#getCloudSystem_Arq()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ArchitectureSpecification> getArq();

	/**
	 * Returns the value of the '<em><b>Configs</b></em>' containment reference list.
	 * The list contents are of type {@link cloudRobotics.Configuration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configs</em>' containment reference list.
	 * @see cloudRobotics.cloudRoboticsPackage#getCloudSystem_Configs()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Configuration> getConfigs();

} // CloudSystem
