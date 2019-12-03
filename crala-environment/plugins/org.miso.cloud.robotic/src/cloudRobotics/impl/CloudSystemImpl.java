/**
 */
package cloudRobotics.impl;

import cloudRobotics.ArchitectureSpecification;
import cloudRobotics.CloudSystem;
import cloudRobotics.Configuration;
import cloudRobotics.cloudRoboticsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cloud System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cloudRobotics.impl.CloudSystemImpl#getName <em>Name</em>}</li>
 *   <li>{@link cloudRobotics.impl.CloudSystemImpl#getArq <em>Arq</em>}</li>
 *   <li>{@link cloudRobotics.impl.CloudSystemImpl#getConfigs <em>Configs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CloudSystemImpl extends MinimalEObjectImpl.Container implements CloudSystem {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getArq() <em>Arq</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArq()
	 * @generated
	 * @ordered
	 */
	protected EList<ArchitectureSpecification> arq;

	/**
	 * The cached value of the '{@link #getConfigs() <em>Configs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigs()
	 * @generated
	 * @ordered
	 */
	protected EList<Configuration> configs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CloudSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return cloudRoboticsPackage.Literals.CLOUD_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, cloudRoboticsPackage.CLOUD_SYSTEM__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArchitectureSpecification> getArq() {
		if (arq == null) {
			arq = new EObjectContainmentEList.Resolving<ArchitectureSpecification>(ArchitectureSpecification.class, this, cloudRoboticsPackage.CLOUD_SYSTEM__ARQ);
		}
		return arq;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Configuration> getConfigs() {
		if (configs == null) {
			configs = new EObjectContainmentEList.Resolving<Configuration>(Configuration.class, this, cloudRoboticsPackage.CLOUD_SYSTEM__CONFIGS);
		}
		return configs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case cloudRoboticsPackage.CLOUD_SYSTEM__ARQ:
				return ((InternalEList<?>)getArq()).basicRemove(otherEnd, msgs);
			case cloudRoboticsPackage.CLOUD_SYSTEM__CONFIGS:
				return ((InternalEList<?>)getConfigs()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case cloudRoboticsPackage.CLOUD_SYSTEM__NAME:
				return getName();
			case cloudRoboticsPackage.CLOUD_SYSTEM__ARQ:
				return getArq();
			case cloudRoboticsPackage.CLOUD_SYSTEM__CONFIGS:
				return getConfigs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case cloudRoboticsPackage.CLOUD_SYSTEM__NAME:
				setName((String)newValue);
				return;
			case cloudRoboticsPackage.CLOUD_SYSTEM__ARQ:
				getArq().clear();
				getArq().addAll((Collection<? extends ArchitectureSpecification>)newValue);
				return;
			case cloudRoboticsPackage.CLOUD_SYSTEM__CONFIGS:
				getConfigs().clear();
				getConfigs().addAll((Collection<? extends Configuration>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case cloudRoboticsPackage.CLOUD_SYSTEM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case cloudRoboticsPackage.CLOUD_SYSTEM__ARQ:
				getArq().clear();
				return;
			case cloudRoboticsPackage.CLOUD_SYSTEM__CONFIGS:
				getConfigs().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case cloudRoboticsPackage.CLOUD_SYSTEM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case cloudRoboticsPackage.CLOUD_SYSTEM__ARQ:
				return arq != null && !arq.isEmpty();
			case cloudRoboticsPackage.CLOUD_SYSTEM__CONFIGS:
				return configs != null && !configs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //CloudSystemImpl
