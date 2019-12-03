/**
 */
package cloudRobotics.impl;

import cloudRobotics.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class cloudRoboticsFactoryImpl extends EFactoryImpl implements cloudRoboticsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static cloudRoboticsFactory init() {
		try {
			cloudRoboticsFactory thecloudRoboticsFactory = (cloudRoboticsFactory)EPackage.Registry.INSTANCE.getEFactory(cloudRoboticsPackage.eNS_URI);
			if (thecloudRoboticsFactory != null) {
				return thecloudRoboticsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new cloudRoboticsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public cloudRoboticsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case cloudRoboticsPackage.CLOUD_SYSTEM: return createCloudSystem();
			case cloudRoboticsPackage.ARCHITECTURE_SPECIFICATION: return createArchitectureSpecification();
			case cloudRoboticsPackage.ROBOT: return createRobot();
			case cloudRoboticsPackage.SENSOR_TYPE: return createSensorType();
			case cloudRoboticsPackage.ROLE: return createRole();
			case cloudRoboticsPackage.CONNECTION_ELEMENT: return createConnectionElement();
			case cloudRoboticsPackage.CONFIGURATION: return createConfiguration();
			case cloudRoboticsPackage.CONFIGURATION_SYSTEM: return createConfigurationSystem();
			case cloudRoboticsPackage.VIRTUAL_MACHINE: return createVirtualMachine();
			case cloudRoboticsPackage.COMPONENT_CLASS: return createComponentClass();
			case cloudRoboticsPackage.WEB_SERVICE: return createWebService();
			case cloudRoboticsPackage.CONNECTION_COMPONENT: return createConnectionComponent();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CloudSystem createCloudSystem() {
		CloudSystemImpl cloudSystem = new CloudSystemImpl();
		return cloudSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureSpecification createArchitectureSpecification() {
		ArchitectureSpecificationImpl architectureSpecification = new ArchitectureSpecificationImpl();
		return architectureSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Robot createRobot() {
		RobotImpl robot = new RobotImpl();
		return robot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SensorType createSensorType() {
		SensorTypeImpl sensorType = new SensorTypeImpl();
		return sensorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Role createRole() {
		RoleImpl role = new RoleImpl();
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionElement createConnectionElement() {
		ConnectionElementImpl connectionElement = new ConnectionElementImpl();
		return connectionElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Configuration createConfiguration() {
		ConfigurationImpl configuration = new ConfigurationImpl();
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationSystem createConfigurationSystem() {
		ConfigurationSystemImpl configurationSystem = new ConfigurationSystemImpl();
		return configurationSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualMachine createVirtualMachine() {
		VirtualMachineImpl virtualMachine = new VirtualMachineImpl();
		return virtualMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentClass createComponentClass() {
		ComponentClassImpl componentClass = new ComponentClassImpl();
		return componentClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WebService createWebService() {
		WebServiceImpl webService = new WebServiceImpl();
		return webService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionComponent createConnectionComponent() {
		ConnectionComponentImpl connectionComponent = new ConnectionComponentImpl();
		return connectionComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public cloudRoboticsPackage getcloudRoboticsPackage() {
		return (cloudRoboticsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static cloudRoboticsPackage getPackage() {
		return cloudRoboticsPackage.eINSTANCE;
	}

} //cloudRoboticsFactoryImpl
