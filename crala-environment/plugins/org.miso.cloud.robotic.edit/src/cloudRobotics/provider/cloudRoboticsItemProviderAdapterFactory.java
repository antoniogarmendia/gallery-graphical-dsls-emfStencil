/**
 */
package cloudRobotics.provider;

import cloudRobotics.util.cloudRoboticsAdapterFactory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class cloudRoboticsItemProviderAdapterFactory extends cloudRoboticsAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public cloudRoboticsItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link cloudRobotics.CloudSystem} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CloudSystemItemProvider cloudSystemItemProvider;

	/**
	 * This creates an adapter for a {@link cloudRobotics.CloudSystem}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCloudSystemAdapter() {
		if (cloudSystemItemProvider == null) {
			cloudSystemItemProvider = new CloudSystemItemProvider(this);
		}

		return cloudSystemItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link cloudRobotics.ArchitectureSpecification} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArchitectureSpecificationItemProvider architectureSpecificationItemProvider;

	/**
	 * This creates an adapter for a {@link cloudRobotics.ArchitectureSpecification}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createArchitectureSpecificationAdapter() {
		if (architectureSpecificationItemProvider == null) {
			architectureSpecificationItemProvider = new ArchitectureSpecificationItemProvider(this);
		}

		return architectureSpecificationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link cloudRobotics.Robot} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RobotItemProvider robotItemProvider;

	/**
	 * This creates an adapter for a {@link cloudRobotics.Robot}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRobotAdapter() {
		if (robotItemProvider == null) {
			robotItemProvider = new RobotItemProvider(this);
		}

		return robotItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link cloudRobotics.SensorType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SensorTypeItemProvider sensorTypeItemProvider;

	/**
	 * This creates an adapter for a {@link cloudRobotics.SensorType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSensorTypeAdapter() {
		if (sensorTypeItemProvider == null) {
			sensorTypeItemProvider = new SensorTypeItemProvider(this);
		}

		return sensorTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link cloudRobotics.Role} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoleItemProvider roleItemProvider;

	/**
	 * This creates an adapter for a {@link cloudRobotics.Role}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRoleAdapter() {
		if (roleItemProvider == null) {
			roleItemProvider = new RoleItemProvider(this);
		}

		return roleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link cloudRobotics.ConnectionElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionElementItemProvider connectionElementItemProvider;

	/**
	 * This creates an adapter for a {@link cloudRobotics.ConnectionElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createConnectionElementAdapter() {
		if (connectionElementItemProvider == null) {
			connectionElementItemProvider = new ConnectionElementItemProvider(this);
		}

		return connectionElementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link cloudRobotics.Configuration} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationItemProvider configurationItemProvider;

	/**
	 * This creates an adapter for a {@link cloudRobotics.Configuration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createConfigurationAdapter() {
		if (configurationItemProvider == null) {
			configurationItemProvider = new ConfigurationItemProvider(this);
		}

		return configurationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link cloudRobotics.ConfigurationSystem} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationSystemItemProvider configurationSystemItemProvider;

	/**
	 * This creates an adapter for a {@link cloudRobotics.ConfigurationSystem}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createConfigurationSystemAdapter() {
		if (configurationSystemItemProvider == null) {
			configurationSystemItemProvider = new ConfigurationSystemItemProvider(this);
		}

		return configurationSystemItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link cloudRobotics.VirtualMachine} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualMachineItemProvider virtualMachineItemProvider;

	/**
	 * This creates an adapter for a {@link cloudRobotics.VirtualMachine}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createVirtualMachineAdapter() {
		if (virtualMachineItemProvider == null) {
			virtualMachineItemProvider = new VirtualMachineItemProvider(this);
		}

		return virtualMachineItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link cloudRobotics.ComponentClass} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentClassItemProvider componentClassItemProvider;

	/**
	 * This creates an adapter for a {@link cloudRobotics.ComponentClass}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createComponentClassAdapter() {
		if (componentClassItemProvider == null) {
			componentClassItemProvider = new ComponentClassItemProvider(this);
		}

		return componentClassItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link cloudRobotics.WebService} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WebServiceItemProvider webServiceItemProvider;

	/**
	 * This creates an adapter for a {@link cloudRobotics.WebService}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createWebServiceAdapter() {
		if (webServiceItemProvider == null) {
			webServiceItemProvider = new WebServiceItemProvider(this);
		}

		return webServiceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link cloudRobotics.ConnectionComponent} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionComponentItemProvider connectionComponentItemProvider;

	/**
	 * This creates an adapter for a {@link cloudRobotics.ConnectionComponent}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createConnectionComponentAdapter() {
		if (connectionComponentItemProvider == null) {
			connectionComponentItemProvider = new ConnectionComponentItemProvider(this);
		}

		return connectionComponentItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (cloudSystemItemProvider != null) cloudSystemItemProvider.dispose();
		if (architectureSpecificationItemProvider != null) architectureSpecificationItemProvider.dispose();
		if (robotItemProvider != null) robotItemProvider.dispose();
		if (sensorTypeItemProvider != null) sensorTypeItemProvider.dispose();
		if (roleItemProvider != null) roleItemProvider.dispose();
		if (connectionElementItemProvider != null) connectionElementItemProvider.dispose();
		if (configurationItemProvider != null) configurationItemProvider.dispose();
		if (configurationSystemItemProvider != null) configurationSystemItemProvider.dispose();
		if (virtualMachineItemProvider != null) virtualMachineItemProvider.dispose();
		if (componentClassItemProvider != null) componentClassItemProvider.dispose();
		if (webServiceItemProvider != null) webServiceItemProvider.dispose();
		if (connectionComponentItemProvider != null) connectionComponentItemProvider.dispose();
	}

}
