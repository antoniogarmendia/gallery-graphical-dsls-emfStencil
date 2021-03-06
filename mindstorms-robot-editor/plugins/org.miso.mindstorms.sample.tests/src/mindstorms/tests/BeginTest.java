/**
 */
package mindstorms.tests;

import junit.textui.TestRunner;

import mindstorms.Begin;
import mindstorms.MindstormsFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Begin</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class BeginTest extends ActionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(BeginTest.class);
	}

	/**
	 * Constructs a new Begin test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BeginTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Begin test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Begin getFixture() {
		return (Begin)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(MindstormsFactory.eINSTANCE.createBegin());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //BeginTest
