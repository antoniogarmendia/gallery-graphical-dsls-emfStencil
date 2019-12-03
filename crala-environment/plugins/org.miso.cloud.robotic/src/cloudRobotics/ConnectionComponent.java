/**
 */
package cloudRobotics;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cloudRobotics.ConnectionComponent#getSource <em>Source</em>}</li>
 *   <li>{@link cloudRobotics.ConnectionComponent#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see cloudRobotics.cloudRoboticsPackage#getConnectionComponent()
 * @model
 * @generated
 */
public interface ConnectionComponent extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(ConfigurationComponent)
	 * @see cloudRobotics.cloudRoboticsPackage#getConnectionComponent_Source()
	 * @model
	 * @generated
	 */
	ConfigurationComponent getSource();

	/**
	 * Sets the value of the '{@link cloudRobotics.ConnectionComponent#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(ConfigurationComponent value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(ConfigurationComponent)
	 * @see cloudRobotics.cloudRoboticsPackage#getConnectionComponent_Target()
	 * @model
	 * @generated
	 */
	ConfigurationComponent getTarget();

	/**
	 * Sets the value of the '{@link cloudRobotics.ConnectionComponent#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(ConfigurationComponent value);

} // ConnectionComponent
