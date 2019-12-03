/**
 */
package mindstorms;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Choreography</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mindstorms.Choreography#getInstructions <em>Instructions</em>}</li>
 *   <li>{@link mindstorms.Choreography#getEdgeInstructions <em>Edge Instructions</em>}</li>
 * </ul>
 *
 * @see mindstorms.MindstormsPackage#getChoreography()
 * @model
 * @generated
 */
public interface Choreography extends Instruction {
	/**
	 * Returns the value of the '<em><b>Instructions</b></em>' containment reference list.
	 * The list contents are of type {@link mindstorms.Instruction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instructions</em>' containment reference list.
	 * @see mindstorms.MindstormsPackage#getChoreography_Instructions()
	 * @model type="mindstorms.Instruction" containment="true"
	 * @generated
	 */
	EList getInstructions();

	/**
	 * Returns the value of the '<em><b>Edge Instructions</b></em>' containment reference list.
	 * The list contents are of type {@link mindstorms.EdgeInstruction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edge Instructions</em>' containment reference list.
	 * @see mindstorms.MindstormsPackage#getChoreography_EdgeInstructions()
	 * @model type="mindstorms.EdgeInstruction" containment="true"
	 * @generated
	 */
	EList getEdgeInstructions();

} // Choreography
