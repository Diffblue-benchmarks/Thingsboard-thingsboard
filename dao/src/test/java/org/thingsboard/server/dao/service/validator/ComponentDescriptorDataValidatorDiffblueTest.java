package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.plugin.ComponentDescriptor;
import org.thingsboard.server.common.data.plugin.ComponentScope;
import org.thingsboard.server.common.data.plugin.ComponentType;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {ComponentDescriptorDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ComponentDescriptorDataValidatorDiffblueTest {
  @Autowired
  private ComponentDescriptorDataValidator componentDescriptorDataValidator;

  /**
   * Test {@link ComponentDescriptorDataValidator#validateDataImpl(TenantId, ComponentDescriptor)} with {@code TenantId}, {@code ComponentDescriptor}.
   * <p>
   * Method under test: {@link ComponentDescriptorDataValidator#validateDataImpl(TenantId, ComponentDescriptor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ComponentDescriptorDataValidator.validateDataImpl(TenantId, ComponentDescriptor)"})
  public void testValidateDataImplWithTenantIdComponentDescriptor() {
    // Arrange
    ComponentDescriptor plugin = new ComponentDescriptor();
    plugin.setName("Component name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> componentDescriptorDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, plugin));
  }

  /**
   * Test {@link ComponentDescriptorDataValidator#validateDataImpl(TenantId, ComponentDescriptor)} with {@code TenantId}, {@code ComponentDescriptor}.
   * <p>
   * Method under test: {@link ComponentDescriptorDataValidator#validateDataImpl(TenantId, ComponentDescriptor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ComponentDescriptorDataValidator.validateDataImpl(TenantId, ComponentDescriptor)"})
  public void testValidateDataImplWithTenantIdComponentDescriptor2() {
    // Arrange
    ComponentDescriptor plugin = new ComponentDescriptor();
    plugin.setType(ComponentType.ENRICHMENT);
    plugin.setName("Component name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> componentDescriptorDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, plugin));
  }

  /**
   * Test {@link ComponentDescriptorDataValidator#validateDataImpl(TenantId, ComponentDescriptor)} with {@code TenantId}, {@code ComponentDescriptor}.
   * <ul>
   *   <li>Given {@code SYSTEM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComponentDescriptorDataValidator#validateDataImpl(TenantId, ComponentDescriptor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ComponentDescriptorDataValidator.validateDataImpl(TenantId, ComponentDescriptor)"})
  public void testValidateDataImplWithTenantIdComponentDescriptor_givenSystem() {
    // Arrange
    ComponentDescriptor plugin = new ComponentDescriptor();
    plugin.setScope(ComponentScope.SYSTEM);
    plugin.setType(ComponentType.ENRICHMENT);
    plugin.setName("Component name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> componentDescriptorDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, plugin));
  }
}
