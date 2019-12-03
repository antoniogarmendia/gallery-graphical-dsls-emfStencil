/**
 */
package mindstorms.tests;

import junit.textui.TestRunner;

import mindstorms.GoBackward;
import mindstorms.MindstormsFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Go Backward</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class GoBackwardTest extends ActionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(GoBackwardTest.class);
	}

	/**
	 * Constructs a new Go Backward test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GoBackwardTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Go Backward test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private GoBackward getFixture() {
		return (GoBackward)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(MindstormsFactory.eINSTANCE.createGoBackward());
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

} //GoBackwardTest
