/**
 */
package caex.caex30.caex.tests;

import caex.caex30.caex.CAEXFactory;
import caex.caex30.caex.InternalElement;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Internal Element</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class InternalElementTest extends SystemUnitClassTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(InternalElementTest.class);
	}

	/**
	 * Constructs a new Internal Element test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalElementTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Internal Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected InternalElement getFixture() {
		return (InternalElement)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(CAEXFactory.eINSTANCE.createInternalElement());
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

} //InternalElementTest
