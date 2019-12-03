/**
 */
package caex.caex30.caex.tests;

import caex.caex30.caex.CAEXFactory;
import caex.caex30.caex.RoleRequirements;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Role Requirements</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RoleRequirementsTest extends CAEXBasicObjectTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RoleRequirementsTest.class);
	}

	/**
	 * Constructs a new Role Requirements test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleRequirementsTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Role Requirements test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected RoleRequirements getFixture() {
		return (RoleRequirements)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(CAEXFactory.eINSTANCE.createRoleRequirements());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //RoleRequirementsTest
