/**
 */
package caex.caex30.caex.tests;

import caex.caex30.caex.CAEXFactory;
import caex.caex30.caex.InterfaceFamily;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Interface Family</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class InterfaceFamilyTest extends InterfaceClassTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(InterfaceFamilyTest.class);
	}

	/**
	 * Constructs a new Interface Family test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceFamilyTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Interface Family test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected InterfaceFamily getFixture() {
		return (InterfaceFamily)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(CAEXFactory.eINSTANCE.createInterfaceFamily());
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

} //InterfaceFamilyTest
