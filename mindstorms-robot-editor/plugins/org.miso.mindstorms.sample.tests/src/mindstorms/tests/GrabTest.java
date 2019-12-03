/**
 */
package mindstorms.tests;

import junit.textui.TestRunner;

import mindstorms.Grab;
import mindstorms.MindstormsFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Grab</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class GrabTest extends ActionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(GrabTest.class);
	}

	/**
	 * Constructs a new Grab test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GrabTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Grab test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Grab getFixture() {
		return (Grab)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(MindstormsFactory.eINSTANCE.createGrab());
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

} //GrabTest
