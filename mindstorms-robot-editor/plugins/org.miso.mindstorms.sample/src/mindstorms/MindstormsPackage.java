/**
 */
package mindstorms;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see mindstorms.MindstormsFactory
 * @model kind="package"
 * @generated
 */
public interface MindstormsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "mindstorms";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.obeo.fr/dsl/mindstorms/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "mindstorms";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MindstormsPackage eINSTANCE = mindstorms.impl.MindstormsPackageImpl.init();

	/**
	 * The meta object id for the '{@link mindstorms.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mindstorms.impl.NamedElementImpl
	 * @see mindstorms.impl.MindstormsPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link mindstorms.impl.InstructionImpl <em>Instruction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mindstorms.impl.InstructionImpl
	 * @see mindstorms.impl.MindstormsPackageImpl#getInstruction()
	 * @generated
	 */
	int INSTRUCTION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Instruction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link mindstorms.impl.BlockImpl <em>Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mindstorms.impl.BlockImpl
	 * @see mindstorms.impl.MindstormsPackageImpl#getBlock()
	 * @generated
	 */
	int BLOCK = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__NAME = INSTRUCTION__NAME;

	/**
	 * The number of structural features of the '<em>Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link mindstorms.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mindstorms.impl.ActionImpl
	 * @see mindstorms.impl.MindstormsPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__NAME = BLOCK__NAME;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = BLOCK_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link mindstorms.impl.GoForwardImpl <em>Go Forward</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mindstorms.impl.GoForwardImpl
	 * @see mindstorms.impl.MindstormsPackageImpl#getGoForward()
	 * @generated
	 */
	int GO_FORWARD = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GO_FORWARD__NAME = ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Cm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GO_FORWARD__CM = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Infinite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GO_FORWARD__INFINITE = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Go Forward</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GO_FORWARD_FEATURE_COUNT = ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link mindstorms.impl.GoBackwardImpl <em>Go Backward</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mindstorms.impl.GoBackwardImpl
	 * @see mindstorms.impl.MindstormsPackageImpl#getGoBackward()
	 * @generated
	 */
	int GO_BACKWARD = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GO_BACKWARD__NAME = ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Cm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GO_BACKWARD__CM = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Infinite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GO_BACKWARD__INFINITE = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Go Backward</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GO_BACKWARD_FEATURE_COUNT = ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link mindstorms.impl.BeginImpl <em>Begin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mindstorms.impl.BeginImpl
	 * @see mindstorms.impl.MindstormsPackageImpl#getBegin()
	 * @generated
	 */
	int BEGIN = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEGIN__NAME = ACTION__NAME;

	/**
	 * The number of structural features of the '<em>Begin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEGIN_FEATURE_COUNT = ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link mindstorms.impl.RotateImpl <em>Rotate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mindstorms.impl.RotateImpl
	 * @see mindstorms.impl.MindstormsPackageImpl#getRotate()
	 * @generated
	 */
	int ROTATE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROTATE__NAME = ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Degrees</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROTATE__DEGREES = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Random</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROTATE__RANDOM = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Rotate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROTATE_FEATURE_COUNT = ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link mindstorms.impl.ReleaseImpl <em>Release</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mindstorms.impl.ReleaseImpl
	 * @see mindstorms.impl.MindstormsPackageImpl#getRelease()
	 * @generated
	 */
	int RELEASE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__NAME = ACTION__NAME;

	/**
	 * The number of structural features of the '<em>Release</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE_FEATURE_COUNT = ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link mindstorms.impl.EndImpl <em>End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mindstorms.impl.EndImpl
	 * @see mindstorms.impl.MindstormsPackageImpl#getEnd()
	 * @generated
	 */
	int END = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__NAME = ACTION__NAME;

	/**
	 * The number of structural features of the '<em>End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_FEATURE_COUNT = ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link mindstorms.impl.ChoreographyImpl <em>Choreography</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mindstorms.impl.ChoreographyImpl
	 * @see mindstorms.impl.MindstormsPackageImpl#getChoreography()
	 * @generated
	 */
	int CHOREOGRAPHY = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOREOGRAPHY__NAME = INSTRUCTION__NAME;

	/**
	 * The feature id for the '<em><b>Instructions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOREOGRAPHY__INSTRUCTIONS = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Edge Instructions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOREOGRAPHY__EDGE_INSTRUCTIONS = INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Choreography</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOREOGRAPHY_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link mindstorms.impl.EdgeInstructionImpl <em>Edge Instruction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mindstorms.impl.EdgeInstructionImpl
	 * @see mindstorms.impl.MindstormsPackageImpl#getEdgeInstruction()
	 * @generated
	 */
	int EDGE_INSTRUCTION = 11;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_INSTRUCTION__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_INSTRUCTION__TARGET = 1;

	/**
	 * The number of structural features of the '<em>Edge Instruction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_INSTRUCTION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link mindstorms.impl.GrabImpl <em>Grab</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mindstorms.impl.GrabImpl
	 * @see mindstorms.impl.MindstormsPackageImpl#getGrab()
	 * @generated
	 */
	int GRAB = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAB__NAME = ACTION__NAME;

	/**
	 * The number of structural features of the '<em>Grab</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAB_FEATURE_COUNT = ACTION_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link mindstorms.Instruction <em>Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instruction</em>'.
	 * @see mindstorms.Instruction
	 * @generated
	 */
	EClass getInstruction();

	/**
	 * Returns the meta object for class '{@link mindstorms.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see mindstorms.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link mindstorms.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see mindstorms.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link mindstorms.GoForward <em>Go Forward</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Go Forward</em>'.
	 * @see mindstorms.GoForward
	 * @generated
	 */
	EClass getGoForward();

	/**
	 * Returns the meta object for the attribute '{@link mindstorms.GoForward#getCm <em>Cm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cm</em>'.
	 * @see mindstorms.GoForward#getCm()
	 * @see #getGoForward()
	 * @generated
	 */
	EAttribute getGoForward_Cm();

	/**
	 * Returns the meta object for the attribute '{@link mindstorms.GoForward#isInfinite <em>Infinite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Infinite</em>'.
	 * @see mindstorms.GoForward#isInfinite()
	 * @see #getGoForward()
	 * @generated
	 */
	EAttribute getGoForward_Infinite();

	/**
	 * Returns the meta object for class '{@link mindstorms.GoBackward <em>Go Backward</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Go Backward</em>'.
	 * @see mindstorms.GoBackward
	 * @generated
	 */
	EClass getGoBackward();

	/**
	 * Returns the meta object for the attribute '{@link mindstorms.GoBackward#getCm <em>Cm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cm</em>'.
	 * @see mindstorms.GoBackward#getCm()
	 * @see #getGoBackward()
	 * @generated
	 */
	EAttribute getGoBackward_Cm();

	/**
	 * Returns the meta object for the attribute '{@link mindstorms.GoBackward#isInfinite <em>Infinite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Infinite</em>'.
	 * @see mindstorms.GoBackward#isInfinite()
	 * @see #getGoBackward()
	 * @generated
	 */
	EAttribute getGoBackward_Infinite();

	/**
	 * Returns the meta object for class '{@link mindstorms.Begin <em>Begin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Begin</em>'.
	 * @see mindstorms.Begin
	 * @generated
	 */
	EClass getBegin();

	/**
	 * Returns the meta object for class '{@link mindstorms.Rotate <em>Rotate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rotate</em>'.
	 * @see mindstorms.Rotate
	 * @generated
	 */
	EClass getRotate();

	/**
	 * Returns the meta object for the attribute '{@link mindstorms.Rotate#getDegrees <em>Degrees</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Degrees</em>'.
	 * @see mindstorms.Rotate#getDegrees()
	 * @see #getRotate()
	 * @generated
	 */
	EAttribute getRotate_Degrees();

	/**
	 * Returns the meta object for the attribute '{@link mindstorms.Rotate#isRandom <em>Random</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Random</em>'.
	 * @see mindstorms.Rotate#isRandom()
	 * @see #getRotate()
	 * @generated
	 */
	EAttribute getRotate_Random();

	/**
	 * Returns the meta object for class '{@link mindstorms.Release <em>Release</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Release</em>'.
	 * @see mindstorms.Release
	 * @generated
	 */
	EClass getRelease();

	/**
	 * Returns the meta object for class '{@link mindstorms.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see mindstorms.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for class '{@link mindstorms.Block <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block</em>'.
	 * @see mindstorms.Block
	 * @generated
	 */
	EClass getBlock();

	/**
	 * Returns the meta object for class '{@link mindstorms.End <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>End</em>'.
	 * @see mindstorms.End
	 * @generated
	 */
	EClass getEnd();

	/**
	 * Returns the meta object for class '{@link mindstorms.Choreography <em>Choreography</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Choreography</em>'.
	 * @see mindstorms.Choreography
	 * @generated
	 */
	EClass getChoreography();

	/**
	 * Returns the meta object for the containment reference list '{@link mindstorms.Choreography#getInstructions <em>Instructions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instructions</em>'.
	 * @see mindstorms.Choreography#getInstructions()
	 * @see #getChoreography()
	 * @generated
	 */
	EReference getChoreography_Instructions();

	/**
	 * Returns the meta object for the containment reference list '{@link mindstorms.Choreography#getEdgeInstructions <em>Edge Instructions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Edge Instructions</em>'.
	 * @see mindstorms.Choreography#getEdgeInstructions()
	 * @see #getChoreography()
	 * @generated
	 */
	EReference getChoreography_EdgeInstructions();

	/**
	 * Returns the meta object for class '{@link mindstorms.EdgeInstruction <em>Edge Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge Instruction</em>'.
	 * @see mindstorms.EdgeInstruction
	 * @generated
	 */
	EClass getEdgeInstruction();

	/**
	 * Returns the meta object for the reference '{@link mindstorms.EdgeInstruction#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see mindstorms.EdgeInstruction#getSource()
	 * @see #getEdgeInstruction()
	 * @generated
	 */
	EReference getEdgeInstruction_Source();

	/**
	 * Returns the meta object for the reference '{@link mindstorms.EdgeInstruction#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see mindstorms.EdgeInstruction#getTarget()
	 * @see #getEdgeInstruction()
	 * @generated
	 */
	EReference getEdgeInstruction_Target();

	/**
	 * Returns the meta object for class '{@link mindstorms.Grab <em>Grab</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grab</em>'.
	 * @see mindstorms.Grab
	 * @generated
	 */
	EClass getGrab();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MindstormsFactory getMindstormsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link mindstorms.impl.InstructionImpl <em>Instruction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mindstorms.impl.InstructionImpl
		 * @see mindstorms.impl.MindstormsPackageImpl#getInstruction()
		 * @generated
		 */
		EClass INSTRUCTION = eINSTANCE.getInstruction();

		/**
		 * The meta object literal for the '{@link mindstorms.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mindstorms.impl.NamedElementImpl
		 * @see mindstorms.impl.MindstormsPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link mindstorms.impl.GoForwardImpl <em>Go Forward</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mindstorms.impl.GoForwardImpl
		 * @see mindstorms.impl.MindstormsPackageImpl#getGoForward()
		 * @generated
		 */
		EClass GO_FORWARD = eINSTANCE.getGoForward();

		/**
		 * The meta object literal for the '<em><b>Cm</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GO_FORWARD__CM = eINSTANCE.getGoForward_Cm();

		/**
		 * The meta object literal for the '<em><b>Infinite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GO_FORWARD__INFINITE = eINSTANCE.getGoForward_Infinite();

		/**
		 * The meta object literal for the '{@link mindstorms.impl.GoBackwardImpl <em>Go Backward</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mindstorms.impl.GoBackwardImpl
		 * @see mindstorms.impl.MindstormsPackageImpl#getGoBackward()
		 * @generated
		 */
		EClass GO_BACKWARD = eINSTANCE.getGoBackward();

		/**
		 * The meta object literal for the '<em><b>Cm</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GO_BACKWARD__CM = eINSTANCE.getGoBackward_Cm();

		/**
		 * The meta object literal for the '<em><b>Infinite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GO_BACKWARD__INFINITE = eINSTANCE.getGoBackward_Infinite();

		/**
		 * The meta object literal for the '{@link mindstorms.impl.BeginImpl <em>Begin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mindstorms.impl.BeginImpl
		 * @see mindstorms.impl.MindstormsPackageImpl#getBegin()
		 * @generated
		 */
		EClass BEGIN = eINSTANCE.getBegin();

		/**
		 * The meta object literal for the '{@link mindstorms.impl.RotateImpl <em>Rotate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mindstorms.impl.RotateImpl
		 * @see mindstorms.impl.MindstormsPackageImpl#getRotate()
		 * @generated
		 */
		EClass ROTATE = eINSTANCE.getRotate();

		/**
		 * The meta object literal for the '<em><b>Degrees</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROTATE__DEGREES = eINSTANCE.getRotate_Degrees();

		/**
		 * The meta object literal for the '<em><b>Random</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROTATE__RANDOM = eINSTANCE.getRotate_Random();

		/**
		 * The meta object literal for the '{@link mindstorms.impl.ReleaseImpl <em>Release</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mindstorms.impl.ReleaseImpl
		 * @see mindstorms.impl.MindstormsPackageImpl#getRelease()
		 * @generated
		 */
		EClass RELEASE = eINSTANCE.getRelease();

		/**
		 * The meta object literal for the '{@link mindstorms.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mindstorms.impl.ActionImpl
		 * @see mindstorms.impl.MindstormsPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '{@link mindstorms.impl.BlockImpl <em>Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mindstorms.impl.BlockImpl
		 * @see mindstorms.impl.MindstormsPackageImpl#getBlock()
		 * @generated
		 */
		EClass BLOCK = eINSTANCE.getBlock();

		/**
		 * The meta object literal for the '{@link mindstorms.impl.EndImpl <em>End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mindstorms.impl.EndImpl
		 * @see mindstorms.impl.MindstormsPackageImpl#getEnd()
		 * @generated
		 */
		EClass END = eINSTANCE.getEnd();

		/**
		 * The meta object literal for the '{@link mindstorms.impl.ChoreographyImpl <em>Choreography</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mindstorms.impl.ChoreographyImpl
		 * @see mindstorms.impl.MindstormsPackageImpl#getChoreography()
		 * @generated
		 */
		EClass CHOREOGRAPHY = eINSTANCE.getChoreography();

		/**
		 * The meta object literal for the '<em><b>Instructions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOREOGRAPHY__INSTRUCTIONS = eINSTANCE.getChoreography_Instructions();

		/**
		 * The meta object literal for the '<em><b>Edge Instructions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOREOGRAPHY__EDGE_INSTRUCTIONS = eINSTANCE.getChoreography_EdgeInstructions();

		/**
		 * The meta object literal for the '{@link mindstorms.impl.EdgeInstructionImpl <em>Edge Instruction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mindstorms.impl.EdgeInstructionImpl
		 * @see mindstorms.impl.MindstormsPackageImpl#getEdgeInstruction()
		 * @generated
		 */
		EClass EDGE_INSTRUCTION = eINSTANCE.getEdgeInstruction();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_INSTRUCTION__SOURCE = eINSTANCE.getEdgeInstruction_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_INSTRUCTION__TARGET = eINSTANCE.getEdgeInstruction_Target();

		/**
		 * The meta object literal for the '{@link mindstorms.impl.GrabImpl <em>Grab</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mindstorms.impl.GrabImpl
		 * @see mindstorms.impl.MindstormsPackageImpl#getGrab()
		 * @generated
		 */
		EClass GRAB = eINSTANCE.getGrab();

	}

} //MindstormsPackage
