/**
 */
package mindstorms.tests;

import junit.textui.TestRunner;

import mindstorms.MindstormsFactory;
import mindstorms.Release;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Release</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ReleaseTest extends ActionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ReleaseTest.class);
	}

	/**
	 * Constructs a new Release test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReleaseTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Release test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Release getFixture() {
		return (Release)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(MindstormsFactory.eINSTANCE.createRelease());
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

} //ReleaseTest
