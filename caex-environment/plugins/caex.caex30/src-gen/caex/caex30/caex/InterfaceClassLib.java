/**
 */
package caex.caex30.caex;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface Class Lib</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link caex.caex30.caex.InterfaceClassLib#getInterfaceClass <em>Interface Class</em>}</li>
 * </ul>
 *
 * @see caex.caex30.caex.CAEXPackage#getInterfaceClassLib()
 * @model extendedMetaData="name='InterfaceClassLib_._type' kind='elementOnly'"
 * @generated
 */
public interface InterfaceClassLib extends CAEXObject {
	/**
	 * Returns the value of the '<em><b>Interface Class</b></em>' containment reference list.
	 * The list contents are of type {@link caex.caex30.caex.InterfaceClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface Class</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Class definition for interfaces.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Interface Class</em>' containment reference list.
	 * @see caex.caex30.caex.CAEXPackage#getInterfaceClassLib_InterfaceClass()
	 * @model containment="true" resolveProxies="true"
	 *        extendedMetaData="kind='element' name='InterfaceClass' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<InterfaceClass> getInterfaceClass();

} // InterfaceClassLib
