/**
 */
package mindstorms;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge Instruction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mindstorms.EdgeInstruction#getSource <em>Source</em>}</li>
 *   <li>{@link mindstorms.EdgeInstruction#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see mindstorms.MindstormsPackage#getEdgeInstruction()
 * @model
 * @generated
 */
public interface EdgeInstruction extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Instruction)
	 * @see mindstorms.MindstormsPackage#getEdgeInstruction_Source()
	 * @model
	 * @generated
	 */
	Instruction getSource();

	/**
	 * Sets the value of the '{@link mindstorms.EdgeInstruction#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Instruction value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Instruction)
	 * @see mindstorms.MindstormsPackage#getEdgeInstruction_Target()
	 * @model
	 * @generated
	 */
	Instruction getTarget();

	/**
	 * Sets the value of the '{@link mindstorms.EdgeInstruction#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Instruction value);

} // EdgeInstruction
