/**
 */
package mindstorms.impl;

import mindstorms.MindstormsPackage;
import mindstorms.Rotate;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rotate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mindstorms.impl.RotateImpl#getDegrees <em>Degrees</em>}</li>
 *   <li>{@link mindstorms.impl.RotateImpl#isRandom <em>Random</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RotateImpl extends ActionImpl implements Rotate {
	/**
	 * The default value of the '{@link #getDegrees() <em>Degrees</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDegrees()
	 * @generated
	 * @ordered
	 */
	protected static final int DEGREES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDegrees() <em>Degrees</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDegrees()
	 * @generated
	 * @ordered
	 */
	protected int degrees = DEGREES_EDEFAULT;

	/**
	 * The default value of the '{@link #isRandom() <em>Random</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRandom()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RANDOM_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRandom() <em>Random</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRandom()
	 * @generated
	 * @ordered
	 */
	protected boolean random = RANDOM_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RotateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return MindstormsPackage.Literals.ROTATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDegrees() {
		return degrees;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDegrees(int newDegrees) {
		int oldDegrees = degrees;
		degrees = newDegrees;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MindstormsPackage.ROTATE__DEGREES, oldDegrees, degrees));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRandom() {
		return random;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRandom(boolean newRandom) {
		boolean oldRandom = random;
		random = newRandom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MindstormsPackage.ROTATE__RANDOM, oldRandom, random));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MindstormsPackage.ROTATE__DEGREES:
				return new Integer(getDegrees());
			case MindstormsPackage.ROTATE__RANDOM:
				return isRandom() ? Boolean.TRUE : Boolean.FALSE;
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
			case MindstormsPackage.ROTATE__DEGREES:
				setDegrees(((Integer)newValue).intValue());
				return;
			case MindstormsPackage.ROTATE__RANDOM:
				setRandom(((Boolean)newValue).booleanValue());
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
			case MindstormsPackage.ROTATE__DEGREES:
				setDegrees(DEGREES_EDEFAULT);
				return;
			case MindstormsPackage.ROTATE__RANDOM:
				setRandom(RANDOM_EDEFAULT);
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
			case MindstormsPackage.ROTATE__DEGREES:
				return degrees != DEGREES_EDEFAULT;
			case MindstormsPackage.ROTATE__RANDOM:
				return random != RANDOM_EDEFAULT;
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
		result.append(" (degrees: ");
		result.append(degrees);
		result.append(", random: ");
		result.append(random);
		result.append(')');
		return result.toString();
	}

} //RotateImpl
