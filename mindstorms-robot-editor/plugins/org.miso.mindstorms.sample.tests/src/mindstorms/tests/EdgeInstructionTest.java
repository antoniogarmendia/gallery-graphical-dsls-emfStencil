/**
 */
package mindstorms.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import mindstorms.EdgeInstruction;
import mindstorms.MindstormsFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Edge Instruction</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class EdgeInstructionTest extends TestCase {

	/**
	 * The fixture for this Edge Instruction test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EdgeInstruction fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EdgeInstructionTest.class);
	}

	/**
	 * Constructs a new Edge Instruction test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EdgeInstructionTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Edge Instruction test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(EdgeInstruction fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Edge Instruction test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EdgeInstruction getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(MindstormsFactory.eINSTANCE.createEdgeInstruction());
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

} //EdgeInstructionTest
