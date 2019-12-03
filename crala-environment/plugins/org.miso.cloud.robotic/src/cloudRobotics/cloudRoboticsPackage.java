/**
 */
package cloudRobotics;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see cloudRobotics.cloudRoboticsFactory
 * @model kind="package"
 * @generated
 */
public interface cloudRoboticsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cloudRobotics";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://miso.es/cloudRobotics";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cloudRobotics";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	cloudRoboticsPackage eINSTANCE = cloudRobotics.impl.cloudRoboticsPackageImpl.init();

	/**
	 * The meta object id for the '{@link cloudRobotics.impl.CloudSystemImpl <em>Cloud System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cloudRobotics.impl.CloudSystemImpl
	 * @see cloudRobotics.impl.cloudRoboticsPackageImpl#getCloudSystem()
	 * @generated
	 */
	int CLOUD_SYSTEM = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOUD_SYSTEM__NAME = 0;

	/**
	 * The feature id for the '<em><b>Arq</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOUD_SYSTEM__ARQ = 1;

	/**
	 * The feature id for the '<em><b>Configs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOUD_SYSTEM__CONFIGS = 2;

	/**
	 * The number of structural features of the '<em>Cloud System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOUD_SYSTEM_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link cloudRobotics.impl.ArchitectureSpecificationImpl <em>Architecture Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cloudRobotics.impl.ArchitectureSpecificationImpl
	 * @see cloudRobotics.impl.cloudRoboticsPackageImpl#getArchitectureSpecification()
	 * @generated
	 */
	int ARCHITECTURE_SPECIFICATION = 1;

	/**
	 * The feature id for the '<em><b>Robots</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_SPECIFICATION__ROBOTS = 0;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_SPECIFICATION__ROLES = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_SPECIFICATION__NAME = 2;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_SPECIFICATION__CONNECTIONS = 3;

	/**
	 * The number of structural features of the '<em>Architecture Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_SPECIFICATION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link cloudRobotics.impl.RobotImpl <em>Robot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cloudRobotics.impl.RobotImpl
	 * @see cloudRobotics.impl.cloudRoboticsPackageImpl#getRobot()
	 * @generated
	 */
	int ROBOT = 2;

	/**
	 * The feature id for the '<em><b>Sensors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT__SENSORS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT__NAME = 1;

	/**
	 * The number of structural features of the '<em>Robot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link cloudRobotics.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cloudRobotics.impl.ElementImpl
	 * @see cloudRobotics.impl.cloudRoboticsPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 4;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link cloudRobotics.impl.SensorTypeImpl <em>Sensor Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cloudRobotics.impl.SensorTypeImpl
	 * @see cloudRobotics.impl.cloudRoboticsPackageImpl#getSensorType()
	 * @generated
	 */
	int SENSOR_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_TYPE__NAME = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sensor Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_TYPE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link cloudRobotics.impl.RoleImpl <em>Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cloudRobotics.impl.RoleImpl
	 * @see cloudRobotics.impl.cloudRoboticsPackageImpl#getRole()
	 * @generated
	 */
	int ROLE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__NAME = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link cloudRobotics.impl.ConnectionElementImpl <em>Connection Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cloudRobotics.impl.ConnectionElementImpl
	 * @see cloudRobotics.impl.cloudRoboticsPackageImpl#getConnectionElement()
	 * @generated
	 */
	int CONNECTION_ELEMENT = 6;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_ELEMENT__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_ELEMENT__TARGET = 1;

	/**
	 * The number of structural features of the '<em>Connection Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link cloudRobotics.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cloudRobotics.impl.ConfigurationImpl
	 * @see cloudRobotics.impl.cloudRoboticsPackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 7;

	/**
	 * The feature id for the '<em><b>Config Systems</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__CONFIG_SYSTEMS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__NAME = 1;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link cloudRobotics.impl.ConfigurationSystemImpl <em>Configuration System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cloudRobotics.impl.ConfigurationSystemImpl
	 * @see cloudRobotics.impl.cloudRoboticsPackageImpl#getConfigurationSystem()
	 * @generated
	 */
	int CONFIGURATION_SYSTEM = 8;

	/**
	 * The feature id for the '<em><b>Machines</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_SYSTEM__MACHINES = 0;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_SYSTEM__CONNECTIONS = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_SYSTEM__NAME = 2;

	/**
	 * The number of structural features of the '<em>Configuration System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_SYSTEM_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link cloudRobotics.impl.VirtualMachineImpl <em>Virtual Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cloudRobotics.impl.VirtualMachineImpl
	 * @see cloudRobotics.impl.cloudRoboticsPackageImpl#getVirtualMachine()
	 * @generated
	 */
	int VIRTUAL_MACHINE = 9;

	/**
	 * The feature id for the '<em><b>Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_MACHINE__COMPONENTS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_MACHINE__NAME = 1;

	/**
	 * The number of structural features of the '<em>Virtual Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_MACHINE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link cloudRobotics.impl.ConfigurationComponentImpl <em>Configuration Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cloudRobotics.impl.ConfigurationComponentImpl
	 * @see cloudRobotics.impl.cloudRoboticsPackageImpl#getConfigurationComponent()
	 * @generated
	 */
	int CONFIGURATION_COMPONENT = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_COMPONENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Configuration Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_COMPONENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link cloudRobotics.impl.ComponentClassImpl <em>Component Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cloudRobotics.impl.ComponentClassImpl
	 * @see cloudRobotics.impl.cloudRoboticsPackageImpl#getComponentClass()
	 * @generated
	 */
	int COMPONENT_CLASS = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_CLASS__NAME = CONFIGURATION_COMPONENT__NAME;

	/**
	 * The number of structural features of the '<em>Component Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_CLASS_FEATURE_COUNT = CONFIGURATION_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link cloudRobotics.impl.WebServiceImpl <em>Web Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cloudRobotics.impl.WebServiceImpl
	 * @see cloudRobotics.impl.cloudRoboticsPackageImpl#getWebService()
	 * @generated
	 */
	int WEB_SERVICE = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SERVICE__NAME = CONFIGURATION_COMPONENT__NAME;

	/**
	 * The number of structural features of the '<em>Web Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SERVICE_FEATURE_COUNT = CONFIGURATION_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link cloudRobotics.impl.ConnectionComponentImpl <em>Connection Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cloudRobotics.impl.ConnectionComponentImpl
	 * @see cloudRobotics.impl.cloudRoboticsPackageImpl#getConnectionComponent()
	 * @generated
	 */
	int CONNECTION_COMPONENT = 13;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_COMPONENT__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_COMPONENT__TARGET = 1;

	/**
	 * The number of structural features of the '<em>Connection Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_COMPONENT_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link cloudRobotics.CloudSystem <em>Cloud System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cloud System</em>'.
	 * @see cloudRobotics.CloudSystem
	 * @generated
	 */
	EClass getCloudSystem();

	/**
	 * Returns the meta object for the attribute '{@link cloudRobotics.CloudSystem#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see cloudRobotics.CloudSystem#getName()
	 * @see #getCloudSystem()
	 * @generated
	 */
	EAttribute getCloudSystem_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link cloudRobotics.CloudSystem#getArq <em>Arq</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arq</em>'.
	 * @see cloudRobotics.CloudSystem#getArq()
	 * @see #getCloudSystem()
	 * @generated
	 */
	EReference getCloudSystem_Arq();

	/**
	 * Returns the meta object for the containment reference list '{@link cloudRobotics.CloudSystem#getConfigs <em>Configs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Configs</em>'.
	 * @see cloudRobotics.CloudSystem#getConfigs()
	 * @see #getCloudSystem()
	 * @generated
	 */
	EReference getCloudSystem_Configs();

	/**
	 * Returns the meta object for class '{@link cloudRobotics.ArchitectureSpecification <em>Architecture Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Architecture Specification</em>'.
	 * @see cloudRobotics.ArchitectureSpecification
	 * @generated
	 */
	EClass getArchitectureSpecification();

	/**
	 * Returns the meta object for the containment reference list '{@link cloudRobotics.ArchitectureSpecification#getRobots <em>Robots</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Robots</em>'.
	 * @see cloudRobotics.ArchitectureSpecification#getRobots()
	 * @see #getArchitectureSpecification()
	 * @generated
	 */
	EReference getArchitectureSpecification_Robots();

	/**
	 * Returns the meta object for the containment reference list '{@link cloudRobotics.ArchitectureSpecification#getRoles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Roles</em>'.
	 * @see cloudRobotics.ArchitectureSpecification#getRoles()
	 * @see #getArchitectureSpecification()
	 * @generated
	 */
	EReference getArchitectureSpecification_Roles();

	/**
	 * Returns the meta object for the attribute '{@link cloudRobotics.ArchitectureSpecification#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see cloudRobotics.ArchitectureSpecification#getName()
	 * @see #getArchitectureSpecification()
	 * @generated
	 */
	EAttribute getArchitectureSpecification_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link cloudRobotics.ArchitectureSpecification#getConnections <em>Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connections</em>'.
	 * @see cloudRobotics.ArchitectureSpecification#getConnections()
	 * @see #getArchitectureSpecification()
	 * @generated
	 */
	EReference getArchitectureSpecification_Connections();

	/**
	 * Returns the meta object for class '{@link cloudRobotics.Robot <em>Robot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Robot</em>'.
	 * @see cloudRobotics.Robot
	 * @generated
	 */
	EClass getRobot();

	/**
	 * Returns the meta object for the containment reference list '{@link cloudRobotics.Robot#getSensors <em>Sensors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sensors</em>'.
	 * @see cloudRobotics.Robot#getSensors()
	 * @see #getRobot()
	 * @generated
	 */
	EReference getRobot_Sensors();

	/**
	 * Returns the meta object for the attribute '{@link cloudRobotics.Robot#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see cloudRobotics.Robot#getName()
	 * @see #getRobot()
	 * @generated
	 */
	EAttribute getRobot_Name();

	/**
	 * Returns the meta object for class '{@link cloudRobotics.SensorType <em>Sensor Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sensor Type</em>'.
	 * @see cloudRobotics.SensorType
	 * @generated
	 */
	EClass getSensorType();

	/**
	 * Returns the meta object for the attribute '{@link cloudRobotics.SensorType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see cloudRobotics.SensorType#getName()
	 * @see #getSensorType()
	 * @generated
	 */
	EAttribute getSensorType_Name();

	/**
	 * Returns the meta object for class '{@link cloudRobotics.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see cloudRobotics.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for class '{@link cloudRobotics.Role <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role</em>'.
	 * @see cloudRobotics.Role
	 * @generated
	 */
	EClass getRole();

	/**
	 * Returns the meta object for the attribute '{@link cloudRobotics.Role#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see cloudRobotics.Role#getName()
	 * @see #getRole()
	 * @generated
	 */
	EAttribute getRole_Name();

	/**
	 * Returns the meta object for class '{@link cloudRobotics.ConnectionElement <em>Connection Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection Element</em>'.
	 * @see cloudRobotics.ConnectionElement
	 * @generated
	 */
	EClass getConnectionElement();

	/**
	 * Returns the meta object for the reference '{@link cloudRobotics.ConnectionElement#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see cloudRobotics.ConnectionElement#getSource()
	 * @see #getConnectionElement()
	 * @generated
	 */
	EReference getConnectionElement_Source();

	/**
	 * Returns the meta object for the reference '{@link cloudRobotics.ConnectionElement#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see cloudRobotics.ConnectionElement#getTarget()
	 * @see #getConnectionElement()
	 * @generated
	 */
	EReference getConnectionElement_Target();

	/**
	 * Returns the meta object for class '{@link cloudRobotics.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see cloudRobotics.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link cloudRobotics.Configuration#getConfigSystems <em>Config Systems</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Config Systems</em>'.
	 * @see cloudRobotics.Configuration#getConfigSystems()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_ConfigSystems();

	/**
	 * Returns the meta object for the attribute '{@link cloudRobotics.Configuration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see cloudRobotics.Configuration#getName()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Name();

	/**
	 * Returns the meta object for class '{@link cloudRobotics.ConfigurationSystem <em>Configuration System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration System</em>'.
	 * @see cloudRobotics.ConfigurationSystem
	 * @generated
	 */
	EClass getConfigurationSystem();

	/**
	 * Returns the meta object for the containment reference list '{@link cloudRobotics.ConfigurationSystem#getMachines <em>Machines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Machines</em>'.
	 * @see cloudRobotics.ConfigurationSystem#getMachines()
	 * @see #getConfigurationSystem()
	 * @generated
	 */
	EReference getConfigurationSystem_Machines();

	/**
	 * Returns the meta object for the containment reference list '{@link cloudRobotics.ConfigurationSystem#getConnections <em>Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connections</em>'.
	 * @see cloudRobotics.ConfigurationSystem#getConnections()
	 * @see #getConfigurationSystem()
	 * @generated
	 */
	EReference getConfigurationSystem_Connections();

	/**
	 * Returns the meta object for the attribute '{@link cloudRobotics.ConfigurationSystem#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see cloudRobotics.ConfigurationSystem#getName()
	 * @see #getConfigurationSystem()
	 * @generated
	 */
	EAttribute getConfigurationSystem_Name();

	/**
	 * Returns the meta object for class '{@link cloudRobotics.VirtualMachine <em>Virtual Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Machine</em>'.
	 * @see cloudRobotics.VirtualMachine
	 * @generated
	 */
	EClass getVirtualMachine();

	/**
	 * Returns the meta object for the containment reference list '{@link cloudRobotics.VirtualMachine#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Components</em>'.
	 * @see cloudRobotics.VirtualMachine#getComponents()
	 * @see #getVirtualMachine()
	 * @generated
	 */
	EReference getVirtualMachine_Components();

	/**
	 * Returns the meta object for the attribute '{@link cloudRobotics.VirtualMachine#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see cloudRobotics.VirtualMachine#getName()
	 * @see #getVirtualMachine()
	 * @generated
	 */
	EAttribute getVirtualMachine_Name();

	/**
	 * Returns the meta object for class '{@link cloudRobotics.ConfigurationComponent <em>Configuration Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration Component</em>'.
	 * @see cloudRobotics.ConfigurationComponent
	 * @generated
	 */
	EClass getConfigurationComponent();

	/**
	 * Returns the meta object for the attribute '{@link cloudRobotics.ConfigurationComponent#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see cloudRobotics.ConfigurationComponent#getName()
	 * @see #getConfigurationComponent()
	 * @generated
	 */
	EAttribute getConfigurationComponent_Name();

	/**
	 * Returns the meta object for class '{@link cloudRobotics.ComponentClass <em>Component Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Class</em>'.
	 * @see cloudRobotics.ComponentClass
	 * @generated
	 */
	EClass getComponentClass();

	/**
	 * Returns the meta object for class '{@link cloudRobotics.WebService <em>Web Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Web Service</em>'.
	 * @see cloudRobotics.WebService
	 * @generated
	 */
	EClass getWebService();

	/**
	 * Returns the meta object for class '{@link cloudRobotics.ConnectionComponent <em>Connection Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection Component</em>'.
	 * @see cloudRobotics.ConnectionComponent
	 * @generated
	 */
	EClass getConnectionComponent();

	/**
	 * Returns the meta object for the reference '{@link cloudRobotics.ConnectionComponent#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see cloudRobotics.ConnectionComponent#getSource()
	 * @see #getConnectionComponent()
	 * @generated
	 */
	EReference getConnectionComponent_Source();

	/**
	 * Returns the meta object for the reference '{@link cloudRobotics.ConnectionComponent#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see cloudRobotics.ConnectionComponent#getTarget()
	 * @see #getConnectionComponent()
	 * @generated
	 */
	EReference getConnectionComponent_Target();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	cloudRoboticsFactory getcloudRoboticsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link cloudRobotics.impl.CloudSystemImpl <em>Cloud System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cloudRobotics.impl.CloudSystemImpl
		 * @see cloudRobotics.impl.cloudRoboticsPackageImpl#getCloudSystem()
		 * @generated
		 */
		EClass CLOUD_SYSTEM = eINSTANCE.getCloudSystem();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLOUD_SYSTEM__NAME = eINSTANCE.getCloudSystem_Name();

		/**
		 * The meta object literal for the '<em><b>Arq</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLOUD_SYSTEM__ARQ = eINSTANCE.getCloudSystem_Arq();

		/**
		 * The meta object literal for the '<em><b>Configs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLOUD_SYSTEM__CONFIGS = eINSTANCE.getCloudSystem_Configs();

		/**
		 * The meta object literal for the '{@link cloudRobotics.impl.ArchitectureSpecificationImpl <em>Architecture Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cloudRobotics.impl.ArchitectureSpecificationImpl
		 * @see cloudRobotics.impl.cloudRoboticsPackageImpl#getArchitectureSpecification()
		 * @generated
		 */
		EClass ARCHITECTURE_SPECIFICATION = eINSTANCE.getArchitectureSpecification();

		/**
		 * The meta object literal for the '<em><b>Robots</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_SPECIFICATION__ROBOTS = eINSTANCE.getArchitectureSpecification_Robots();

		/**
		 * The meta object literal for the '<em><b>Roles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_SPECIFICATION__ROLES = eINSTANCE.getArchitectureSpecification_Roles();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARCHITECTURE_SPECIFICATION__NAME = eINSTANCE.getArchitectureSpecification_Name();

		/**
		 * The meta object literal for the '<em><b>Connections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_SPECIFICATION__CONNECTIONS = eINSTANCE.getArchitectureSpecification_Connections();

		/**
		 * The meta object literal for the '{@link cloudRobotics.impl.RobotImpl <em>Robot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cloudRobotics.impl.RobotImpl
		 * @see cloudRobotics.impl.cloudRoboticsPackageImpl#getRobot()
		 * @generated
		 */
		EClass ROBOT = eINSTANCE.getRobot();

		/**
		 * The meta object literal for the '<em><b>Sensors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROBOT__SENSORS = eINSTANCE.getRobot_Sensors();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROBOT__NAME = eINSTANCE.getRobot_Name();

		/**
		 * The meta object literal for the '{@link cloudRobotics.impl.SensorTypeImpl <em>Sensor Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cloudRobotics.impl.SensorTypeImpl
		 * @see cloudRobotics.impl.cloudRoboticsPackageImpl#getSensorType()
		 * @generated
		 */
		EClass SENSOR_TYPE = eINSTANCE.getSensorType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SENSOR_TYPE__NAME = eINSTANCE.getSensorType_Name();

		/**
		 * The meta object literal for the '{@link cloudRobotics.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cloudRobotics.impl.ElementImpl
		 * @see cloudRobotics.impl.cloudRoboticsPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '{@link cloudRobotics.impl.RoleImpl <em>Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cloudRobotics.impl.RoleImpl
		 * @see cloudRobotics.impl.cloudRoboticsPackageImpl#getRole()
		 * @generated
		 */
		EClass ROLE = eINSTANCE.getRole();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE__NAME = eINSTANCE.getRole_Name();

		/**
		 * The meta object literal for the '{@link cloudRobotics.impl.ConnectionElementImpl <em>Connection Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cloudRobotics.impl.ConnectionElementImpl
		 * @see cloudRobotics.impl.cloudRoboticsPackageImpl#getConnectionElement()
		 * @generated
		 */
		EClass CONNECTION_ELEMENT = eINSTANCE.getConnectionElement();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_ELEMENT__SOURCE = eINSTANCE.getConnectionElement_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_ELEMENT__TARGET = eINSTANCE.getConnectionElement_Target();

		/**
		 * The meta object literal for the '{@link cloudRobotics.impl.ConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cloudRobotics.impl.ConfigurationImpl
		 * @see cloudRobotics.impl.cloudRoboticsPackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

		/**
		 * The meta object literal for the '<em><b>Config Systems</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__CONFIG_SYSTEMS = eINSTANCE.getConfiguration_ConfigSystems();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__NAME = eINSTANCE.getConfiguration_Name();

		/**
		 * The meta object literal for the '{@link cloudRobotics.impl.ConfigurationSystemImpl <em>Configuration System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cloudRobotics.impl.ConfigurationSystemImpl
		 * @see cloudRobotics.impl.cloudRoboticsPackageImpl#getConfigurationSystem()
		 * @generated
		 */
		EClass CONFIGURATION_SYSTEM = eINSTANCE.getConfigurationSystem();

		/**
		 * The meta object literal for the '<em><b>Machines</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION_SYSTEM__MACHINES = eINSTANCE.getConfigurationSystem_Machines();

		/**
		 * The meta object literal for the '<em><b>Connections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION_SYSTEM__CONNECTIONS = eINSTANCE.getConfigurationSystem_Connections();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION_SYSTEM__NAME = eINSTANCE.getConfigurationSystem_Name();

		/**
		 * The meta object literal for the '{@link cloudRobotics.impl.VirtualMachineImpl <em>Virtual Machine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cloudRobotics.impl.VirtualMachineImpl
		 * @see cloudRobotics.impl.cloudRoboticsPackageImpl#getVirtualMachine()
		 * @generated
		 */
		EClass VIRTUAL_MACHINE = eINSTANCE.getVirtualMachine();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUAL_MACHINE__COMPONENTS = eINSTANCE.getVirtualMachine_Components();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUAL_MACHINE__NAME = eINSTANCE.getVirtualMachine_Name();

		/**
		 * The meta object literal for the '{@link cloudRobotics.impl.ConfigurationComponentImpl <em>Configuration Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cloudRobotics.impl.ConfigurationComponentImpl
		 * @see cloudRobotics.impl.cloudRoboticsPackageImpl#getConfigurationComponent()
		 * @generated
		 */
		EClass CONFIGURATION_COMPONENT = eINSTANCE.getConfigurationComponent();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION_COMPONENT__NAME = eINSTANCE.getConfigurationComponent_Name();

		/**
		 * The meta object literal for the '{@link cloudRobotics.impl.ComponentClassImpl <em>Component Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cloudRobotics.impl.ComponentClassImpl
		 * @see cloudRobotics.impl.cloudRoboticsPackageImpl#getComponentClass()
		 * @generated
		 */
		EClass COMPONENT_CLASS = eINSTANCE.getComponentClass();

		/**
		 * The meta object literal for the '{@link cloudRobotics.impl.WebServiceImpl <em>Web Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cloudRobotics.impl.WebServiceImpl
		 * @see cloudRobotics.impl.cloudRoboticsPackageImpl#getWebService()
		 * @generated
		 */
		EClass WEB_SERVICE = eINSTANCE.getWebService();

		/**
		 * The meta object literal for the '{@link cloudRobotics.impl.ConnectionComponentImpl <em>Connection Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cloudRobotics.impl.ConnectionComponentImpl
		 * @see cloudRobotics.impl.cloudRoboticsPackageImpl#getConnectionComponent()
		 * @generated
		 */
		EClass CONNECTION_COMPONENT = eINSTANCE.getConnectionComponent();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_COMPONENT__SOURCE = eINSTANCE.getConnectionComponent_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_COMPONENT__TARGET = eINSTANCE.getConnectionComponent_Target();

	}

} //cloudRoboticsPackage
