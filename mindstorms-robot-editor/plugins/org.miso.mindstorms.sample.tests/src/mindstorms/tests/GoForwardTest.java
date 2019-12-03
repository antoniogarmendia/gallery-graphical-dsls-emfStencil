/**
 */
package mindstorms.tests;

import junit.textui.TestRunner;

import mindstorms.GoForward;
import mindstorms.MindstormsFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Go Forward</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class GoForwardTest extends ActionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(GoForwardTest.class);
	}

	/**
	 * Constructs a new Go Forward test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GoForwardTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Go Forward test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private GoForward getFixture() {
		return (GoForward)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(MindstormsFactory.eINSTANCE.createGoForward());
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

} //GoForwardTest
