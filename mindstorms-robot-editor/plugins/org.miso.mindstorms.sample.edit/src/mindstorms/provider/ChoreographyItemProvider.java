/**
 */
package mindstorms.provider;


import java.util.Collection;
import java.util.List;

import mindstorms.Choreography;
import mindstorms.MindstormsFactory;
import mindstorms.MindstormsPackage;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link mindstorms.Choreography} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ChoreographyItemProvider extends InstructionItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChoreographyItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collection getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(MindstormsPackage.Literals.CHOREOGRAPHY__INSTRUCTIONS);
			childrenFeatures.add(MindstormsPackage.Literals.CHOREOGRAPHY__EDGE_INSTRUCTIONS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Choreography.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Choreography"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((Choreography)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Choreography_type") :
			getString("_UI_Choreography_type") + " " + label;
	}


	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Choreography.class)) {
			case MindstormsPackage.CHOREOGRAPHY__INSTRUCTIONS:
			case MindstormsPackage.CHOREOGRAPHY__EDGE_INSTRUCTIONS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void collectNewChildDescriptors(Collection newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.CHOREOGRAPHY__INSTRUCTIONS,
				 MindstormsFactory.eINSTANCE.createGoForward()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.CHOREOGRAPHY__INSTRUCTIONS,
				 MindstormsFactory.eINSTANCE.createGoBackward()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.CHOREOGRAPHY__INSTRUCTIONS,
				 MindstormsFactory.eINSTANCE.createBegin()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.CHOREOGRAPHY__INSTRUCTIONS,
				 MindstormsFactory.eINSTANCE.createRotate()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.CHOREOGRAPHY__INSTRUCTIONS,
				 MindstormsFactory.eINSTANCE.createRelease()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.CHOREOGRAPHY__INSTRUCTIONS,
				 MindstormsFactory.eINSTANCE.createEnd()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.CHOREOGRAPHY__INSTRUCTIONS,
				 MindstormsFactory.eINSTANCE.createChoreography()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.CHOREOGRAPHY__INSTRUCTIONS,
				 MindstormsFactory.eINSTANCE.createGrab()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.CHOREOGRAPHY__EDGE_INSTRUCTIONS,
				 MindstormsFactory.eINSTANCE.createEdgeInstruction()));
	}

}
