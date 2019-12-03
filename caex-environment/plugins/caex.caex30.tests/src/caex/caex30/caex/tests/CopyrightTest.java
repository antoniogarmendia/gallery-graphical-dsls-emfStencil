/**
 */
package caex.caex30.caex.tests;

import caex.caex30.caex.CAEXFactory;
import caex.caex30.caex.Copyright;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Copyright</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class CopyrightTest extends TestCase {

	/**
	 * The fixture for this Copyright test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Copyright fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(CopyrightTest.class);
	}

	/**
	 * Constructs a new Copyright test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CopyrightTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Copyright test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Copyright fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Copyright test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Copyright getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(CAEXFactory.eINSTANCE.createCopyright());
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

} //CopyrightTest
