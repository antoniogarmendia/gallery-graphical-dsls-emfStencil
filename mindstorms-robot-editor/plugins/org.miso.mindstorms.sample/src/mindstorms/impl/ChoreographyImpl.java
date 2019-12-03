/**
 */
package mindstorms.impl;

import java.util.Collection;

import mindstorms.Choreography;
import mindstorms.EdgeInstruction;
import mindstorms.Instruction;
import mindstorms.MindstormsPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Choreography</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mindstorms.impl.ChoreographyImpl#getInstructions <em>Instructions</em>}</li>
 *   <li>{@link mindstorms.impl.ChoreographyImpl#getEdgeInstructions <em>Edge Instructions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ChoreographyImpl extends InstructionImpl implements Choreography {
	/**
	 * The cached value of the '{@link #getInstructions() <em>Instructions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstructions()
	 * @generated
	 * @ordered
	 */
	protected EList instructions;

	/**
	 * The cached value of the '{@link #getEdgeInstructions() <em>Edge Instructions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdgeInstructions()
	 * @generated
	 * @ordered
	 */
	protected EList edgeInstructions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChoreographyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return MindstormsPackage.Literals.CHOREOGRAPHY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getInstructions() {
		if (instructions == null) {
			instructions = new EObjectContainmentEList(Instruction.class, this, MindstormsPackage.CHOREOGRAPHY__INSTRUCTIONS);
		}
		return instructions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getEdgeInstructions() {
		if (edgeInstructions == null) {
			edgeInstructions = new EObjectContainmentEList(EdgeInstruction.class, this, MindstormsPackage.CHOREOGRAPHY__EDGE_INSTRUCTIONS);
		}
		return edgeInstructions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MindstormsPackage.CHOREOGRAPHY__INSTRUCTIONS:
				return ((InternalEList)getInstructions()).basicRemove(otherEnd, msgs);
			case MindstormsPackage.CHOREOGRAPHY__EDGE_INSTRUCTIONS:
				return ((InternalEList)getEdgeInstructions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MindstormsPackage.CHOREOGRAPHY__INSTRUCTIONS:
				return getInstructions();
			case MindstormsPackage.CHOREOGRAPHY__EDGE_INSTRUCTIONS:
				return getEdgeInstructions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MindstormsPackage.CHOREOGRAPHY__INSTRUCTIONS:
				getInstructions().clear();
				getInstructions().addAll((Collection)newValue);
				return;
			case MindstormsPackage.CHOREOGRAPHY__EDGE_INSTRUCTIONS:
				getEdgeInstructions().clear();
				getEdgeInstructions().addAll((Collection)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case MindstormsPackage.CHOREOGRAPHY__INSTRUCTIONS:
				getInstructions().clear();
				return;
			case MindstormsPackage.CHOREOGRAPHY__EDGE_INSTRUCTIONS:
				getEdgeInstructions().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MindstormsPackage.CHOREOGRAPHY__INSTRUCTIONS:
				return instructions != null && !instructions.isEmpty();
			case MindstormsPackage.CHOREOGRAPHY__EDGE_INSTRUCTIONS:
				return edgeInstructions != null && !edgeInstructions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ChoreographyImpl
