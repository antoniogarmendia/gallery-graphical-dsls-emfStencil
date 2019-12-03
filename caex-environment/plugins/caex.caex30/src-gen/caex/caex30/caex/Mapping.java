/**
 */
package caex.caex30.caex;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Base element for AttributeNameMapping and InterfaceIDMapping.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link caex.caex30.caex.Mapping#getAttributeNameMapping <em>Attribute Name Mapping</em>}</li>
 *   <li>{@link caex.caex30.caex.Mapping#getInterfaceIDMapping <em>Interface ID Mapping</em>}</li>
 * </ul>
 *
 * @see caex.caex30.caex.CAEXPackage#getMapping()
 * @model extendedMetaData="name='MappingType' kind='elementOnly'"
 * @generated
 */
public interface Mapping extends CAEXBasicObject {
	/**
	 * Returns the value of the '<em><b>Attribute Name Mapping</b></em>' containment reference list.
	 * The list contents are of type {@link caex.caex30.caex.AttributeNameMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Name Mapping</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Allows the definition of the mapping between attributes of a related role class or its interfaces and attributes of the hosting system unit
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attribute Name Mapping</em>' containment reference list.
	 * @see caex.caex30.caex.CAEXPackage#getMapping_AttributeNameMapping()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='AttributeNameMapping' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<AttributeNameMapping> getAttributeNameMapping();

	/**
	 * Returns the value of the '<em><b>Interface ID Mapping</b></em>' containment reference list.
	 * The list contents are of type {@link caex.caex30.caex.InterfaceIDMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface ID Mapping</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Allows the definition of the mapping between interfaces of a related role class and interfaces of the hosting system unit.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Interface ID Mapping</em>' containment reference list.
	 * @see caex.caex30.caex.CAEXPackage#getMapping_InterfaceIDMapping()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='InterfaceIDMapping' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<InterfaceIDMapping> getInterfaceIDMapping();

} // Mapping
