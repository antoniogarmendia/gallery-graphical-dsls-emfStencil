/**
 */
package cloudRobotics.impl;

import cloudRobotics.ArchitectureSpecification;
import cloudRobotics.ConnectionElement;
import cloudRobotics.Robot;
import cloudRobotics.Role;
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
 * An implementation of the model object '<em><b>Architecture Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cloudRobotics.impl.ArchitectureSpecificationImpl#getRobots <em>Robots</em>}</li>
 *   <li>{@link cloudRobotics.impl.ArchitectureSpecificationImpl#getRoles <em>Roles</em>}</li>
 *   <li>{@link cloudRobotics.impl.ArchitectureSpecificationImpl#getName <em>Name</em>}</li>
 *   <li>{@link cloudRobotics.impl.ArchitectureSpecificationImpl#getConnections <em>Connections</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ArchitectureSpecificationImpl extends MinimalEObjectImpl.Container implements ArchitectureSpecification {
	/**
	 * The cached value of the '{@link #getRobots() <em>Robots</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRobots()
	 * @generated
	 * @ordered
	 */
	protected EList<Robot> robots;

	/**
	 * The cached value of the '{@link #getRoles() <em>Roles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoles()
	 * @generated
	 * @ordered
	 */
	protected EList<Role> roles;

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
	 * The cached value of the '{@link #getConnections() <em>Connections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<ConnectionElement> connections;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArchitectureSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return cloudRoboticsPackage.Literals.ARCHITECTURE_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Robot> getRobots() {
		if (robots == null) {
			robots = new EObjectContainmentEList.Resolving<Robot>(Robot.class, this, cloudRoboticsPackage.ARCHITECTURE_SPECIFICATION__ROBOTS);
		}
		return robots;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Role> getRoles() {
		if (roles == null) {
			roles = new EObjectContainmentEList.Resolving<Role>(Role.class, this, cloudRoboticsPackage.ARCHITECTURE_SPECIFICATION__ROLES);
		}
		return roles;
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
			eNotify(new ENotificationImpl(this, Notification.SET, cloudRoboticsPackage.ARCHITECTURE_SPECIFICATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConnectionElement> getConnections() {
		if (connections == null) {
			connections = new EObjectContainmentEList.Resolving<ConnectionElement>(ConnectionElement.class, this, cloudRoboticsPackage.ARCHITECTURE_SPECIFICATION__CONNECTIONS);
		}
		return connections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case cloudRoboticsPackage.ARCHITECTURE_SPECIFICATION__ROBOTS:
				return ((InternalEList<?>)getRobots()).basicRemove(otherEnd, msgs);
			case cloudRoboticsPackage.ARCHITECTURE_SPECIFICATION__ROLES:
				return ((InternalEList<?>)getRoles()).basicRemove(otherEnd, msgs);
			case cloudRoboticsPackage.ARCHITECTURE_SPECIFICATION__CONNECTIONS:
				return ((InternalEList<?>)getConnections()).basicRemove(otherEnd, msgs);
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
			case cloudRoboticsPackage.ARCHITECTURE_SPECIFICATION__ROBOTS:
				return getRobots();
			case cloudRoboticsPackage.ARCHITECTURE_SPECIFICATION__ROLES:
				return getRoles();
			case cloudRoboticsPackage.ARCHITECTURE_SPECIFICATION__NAME:
				return getName();
			case cloudRoboticsPackage.ARCHITECTURE_SPECIFICATION__CONNECTIONS:
				return getConnections();
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
			case cloudRoboticsPackage.ARCHITECTURE_SPECIFICATION__ROBOTS:
				getRobots().clear();
				getRobots().addAll((Collection<? extends Robot>)newValue);
				return;
			case cloudRoboticsPackage.ARCHITECTURE_SPECIFICATION__ROLES:
				getRoles().clear();
				getRoles().addAll((Collection<? extends Role>)newValue);
				return;
			case cloudRoboticsPackage.ARCHITECTURE_SPECIFICATION__NAME:
				setName((String)newValue);
				return;
			case cloudRoboticsPackage.ARCHITECTURE_SPECIFICATION__CONNECTIONS:
				getConnections().clear();
				getConnections().addAll((Collection<? extends ConnectionElement>)newValue);
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
			case cloudRoboticsPackage.ARCHITECTURE_SPECIFICATION__ROBOTS:
				getRobots().clear();
				return;
			case cloudRoboticsPackage.ARCHITECTURE_SPECIFICATION__ROLES:
				getRoles().clear();
				return;
			case cloudRoboticsPackage.ARCHITECTURE_SPECIFICATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case cloudRoboticsPackage.ARCHITECTURE_SPECIFICATION__CONNECTIONS:
				getConnections().clear();
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
			case cloudRoboticsPackage.ARCHITECTURE_SPECIFICATION__ROBOTS:
				return robots != null && !robots.isEmpty();
			case cloudRoboticsPackage.ARCHITECTURE_SPECIFICATION__ROLES:
				return roles != null && !roles.isEmpty();
			case cloudRoboticsPackage.ARCHITECTURE_SPECIFICATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case cloudRoboticsPackage.ARCHITECTURE_SPECIFICATION__CONNECTIONS:
				return connections != null && !connections.isEmpty();
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

} //ArchitectureSpecificationImpl
