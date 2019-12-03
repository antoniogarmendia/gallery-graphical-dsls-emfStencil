/**
 */
package mindstorms.impl;

import mindstorms.GoForward;
import mindstorms.MindstormsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Go Forward</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mindstorms.impl.GoForwardImpl#getCm <em>Cm</em>}</li>
 *   <li>{@link mindstorms.impl.GoForwardImpl#isInfinite <em>Infinite</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GoForwardImpl extends ActionImpl implements GoForward {
	/**
	 * The default value of the '{@link #getCm() <em>Cm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCm()
	 * @generated
	 * @ordered
	 */
	protected static final int CM_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCm() <em>Cm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCm()
	 * @generated
	 * @ordered
	 */
	protected int cm = CM_EDEFAULT;

	/**
	 * The default value of the '{@link #isInfinite() <em>Infinite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInfinite()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INFINITE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInfinite() <em>Infinite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInfinite()
	 * @generated
	 * @ordered
	 */
	protected boolean infinite = INFINITE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GoForwardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return MindstormsPackage.Literals.GO_FORWARD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCm() {
		return cm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCm(int newCm) {
		int oldCm = cm;
		cm = newCm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MindstormsPackage.GO_FORWARD__CM, oldCm, cm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInfinite() {
		return infinite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInfinite(boolean newInfinite) {
		boolean oldInfinite = infinite;
		infinite = newInfinite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MindstormsPackage.GO_FORWARD__INFINITE, oldInfinite, infinite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MindstormsPackage.GO_FORWARD__CM:
				return new Integer(getCm());
			case MindstormsPackage.GO_FORWARD__INFINITE:
				return isInfinite() ? Boolean.TRUE : Boolean.FALSE;
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
			case MindstormsPackage.GO_FORWARD__CM:
				setCm(((Integer)newValue).intValue());
				return;
			case MindstormsPackage.GO_FORWARD__INFINITE:
				setInfinite(((Boolean)newValue).booleanValue());
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
			case MindstormsPackage.GO_FORWARD__CM:
				setCm(CM_EDEFAULT);
				return;
			case MindstormsPackage.GO_FORWARD__INFINITE:
				setInfinite(INFINITE_EDEFAULT);
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
			case MindstormsPackage.GO_FORWARD__CM:
				return cm != CM_EDEFAULT;
			case MindstormsPackage.GO_FORWARD__INFINITE:
				return infinite != INFINITE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (cm: ");
		result.append(cm);
		result.append(", infinite: ");
		result.append(infinite);
		result.append(')');
		return result.toString();
	}

} //GoForwardImpl
