package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.plugin.ComponentDescriptor;
import org.thingsboard.server.common.data.plugin.ComponentScope;
import org.thingsboard.server.common.data.plugin.ComponentType;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;

@ContextConfiguration(classes = {ComponentDescriptorDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class ComponentDescriptorDataValidatorDiffblueTest {
  @MockBean
  private ApiLimitService apiLimitService;

  @Autowired
  private ComponentDescriptorDataValidator componentDescriptorDataValidator;

  /**
   * Test
   * {@link ComponentDescriptorDataValidator#validateDataImpl(TenantId, ComponentDescriptor)}
   * with {@code TenantId}, {@code ComponentDescriptor}.
   * <p>
   * Method under test:
   * {@link ComponentDescriptorDataValidator#validateDataImpl(TenantId, ComponentDescriptor)}
   */
  @Test
  public void testValidateDataImplWithTenantIdComponentDescriptor() {
    // Arrange
    ComponentDescriptor plugin = mock(ComponentDescriptor.class);
    when(plugin.getClazz()).thenThrow(new DataValidationException("An error occurred"));
    when(plugin.getScope()).thenReturn(ComponentScope.SYSTEM);
    when(plugin.getType()).thenReturn(ComponentType.ENRICHMENT);
    when(plugin.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> componentDescriptorDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, plugin));
    verify(plugin).getClazz();
    verify(plugin).getName();
    verify(plugin).getScope();
    verify(plugin).getType();
  }

  /**
   * Test
   * {@link ComponentDescriptorDataValidator#validateDataImpl(TenantId, ComponentDescriptor)}
   * with {@code TenantId}, {@code ComponentDescriptor}.
   * <p>
   * Method under test:
   * {@link ComponentDescriptorDataValidator#validateDataImpl(TenantId, ComponentDescriptor)}
   */
  @Test
  public void testValidateDataImplWithTenantIdComponentDescriptor2() {
    // Arrange
    ComponentDescriptor plugin = mock(ComponentDescriptor.class);
    when(plugin.getClazz()).thenReturn(null);
    when(plugin.getScope()).thenReturn(ComponentScope.SYSTEM);
    when(plugin.getType()).thenReturn(ComponentType.ENRICHMENT);
    when(plugin.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> componentDescriptorDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, plugin));
    verify(plugin).getClazz();
    verify(plugin).getName();
    verify(plugin).getScope();
    verify(plugin).getType();
  }

  /**
   * Test
   * {@link ComponentDescriptorDataValidator#validateDataImpl(TenantId, ComponentDescriptor)}
   * with {@code TenantId}, {@code ComponentDescriptor}.
   * <p>
   * Method under test:
   * {@link ComponentDescriptorDataValidator#validateDataImpl(TenantId, ComponentDescriptor)}
   */
  @Test
  public void testValidateDataImplWithTenantIdComponentDescriptor3() {
    // Arrange
    ComponentDescriptor plugin = mock(ComponentDescriptor.class);
    when(plugin.getScope()).thenReturn(null);
    when(plugin.getType()).thenReturn(ComponentType.ENRICHMENT);
    when(plugin.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> componentDescriptorDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, plugin));
    verify(plugin).getName();
    verify(plugin).getScope();
    verify(plugin).getType();
  }

  /**
   * Test
   * {@link ComponentDescriptorDataValidator#validateDataImpl(TenantId, ComponentDescriptor)}
   * with {@code TenantId}, {@code ComponentDescriptor}.
   * <ul>
   *   <li>Given {@code Clazz}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ComponentDescriptorDataValidator#validateDataImpl(TenantId, ComponentDescriptor)}
   */
  @Test
  public void testValidateDataImplWithTenantIdComponentDescriptor_givenClazz() {
    // Arrange
    ComponentDescriptor plugin = mock(ComponentDescriptor.class);
    when(plugin.getClazz()).thenReturn("Clazz");
    when(plugin.getScope()).thenReturn(ComponentScope.SYSTEM);
    when(plugin.getType()).thenReturn(ComponentType.ENRICHMENT);
    when(plugin.getName()).thenReturn("Name");

    // Act
    componentDescriptorDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, plugin);

    // Assert that nothing has changed
    verify(plugin).getClazz();
    verify(plugin).getName();
    verify(plugin).getScope();
    verify(plugin).getType();
  }

  /**
   * Test
   * {@link ComponentDescriptorDataValidator#validateDataImpl(TenantId, ComponentDescriptor)}
   * with {@code TenantId}, {@code ComponentDescriptor}.
   * <ul>
   *   <li>Given {@code Component name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ComponentDescriptorDataValidator#validateDataImpl(TenantId, ComponentDescriptor)}
   */
  @Test
  public void testValidateDataImplWithTenantIdComponentDescriptor_givenComponentName() {
    // Arrange
    ComponentDescriptor plugin = new ComponentDescriptor();
    plugin.setName("Component name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> componentDescriptorDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, plugin));
  }

  /**
   * Test
   * {@link ComponentDescriptorDataValidator#validateDataImpl(TenantId, ComponentDescriptor)}
   * with {@code TenantId}, {@code ComponentDescriptor}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ComponentDescriptorDataValidator#validateDataImpl(TenantId, ComponentDescriptor)}
   */
  @Test
  public void testValidateDataImplWithTenantIdComponentDescriptor_givenEmptyString() {
    // Arrange
    ComponentDescriptor plugin = mock(ComponentDescriptor.class);
    when(plugin.getClazz()).thenReturn("");
    when(plugin.getScope()).thenReturn(ComponentScope.SYSTEM);
    when(plugin.getType()).thenReturn(ComponentType.ENRICHMENT);
    when(plugin.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> componentDescriptorDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, plugin));
    verify(plugin).getClazz();
    verify(plugin).getName();
    verify(plugin).getScope();
    verify(plugin).getType();
  }
}
