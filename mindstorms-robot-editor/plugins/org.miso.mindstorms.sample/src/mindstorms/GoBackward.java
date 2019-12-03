/**
 */
package mindstorms;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Go Backward</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mindstorms.GoBackward#getCm <em>Cm</em>}</li>
 *   <li>{@link mindstorms.GoBackward#isInfinite <em>Infinite</em>}</li>
 * </ul>
 *
 * @see mindstorms.MindstormsPackage#getGoBackward()
 * @model
 * @generated
 */
public interface GoBackward extends Action {
	/**
	 * Returns the value of the '<em><b>Cm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cm</em>' attribute.
	 * @see #setCm(int)
	 * @see mindstorms.MindstormsPackage#getGoBackward_Cm()
	 * @model
	 * @generated
	 */
	int getCm();

	/**
	 * Sets the value of the '{@link mindstorms.GoBackward#getCm <em>Cm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cm</em>' attribute.
	 * @see #getCm()
	 * @generated
	 */
	void setCm(int value);

	/**
	 * Returns the value of the '<em><b>Infinite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Infinite</em>' attribute.
	 * @see #setInfinite(boolean)
	 * @see mindstorms.MindstormsPackage#getGoBackward_Infinite()
	 * @model
	 * @generated
	 */
	boolean isInfinite();

	/**
	 * Sets the value of the '{@link mindstorms.GoBackward#isInfinite <em>Infinite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Infinite</em>' attribute.
	 * @see #isInfinite()
	 * @generated
	 */
	void setInfinite(boolean value);

} // GoBackward
