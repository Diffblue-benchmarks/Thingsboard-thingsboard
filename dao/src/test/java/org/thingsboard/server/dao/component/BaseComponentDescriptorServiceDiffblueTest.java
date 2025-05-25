package org.thingsboard.server.dao.component;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.id.ComponentDescriptorId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.plugin.ComponentDescriptor;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.DataValidator;

@ContextConfiguration(classes = {BaseComponentDescriptorService.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseComponentDescriptorServiceDiffblueTest {
  @Autowired
  private BaseComponentDescriptorService baseComponentDescriptorService;

  @MockBean
  private ComponentDescriptorDao componentDescriptorDao;

  @MockBean
  private DataValidator<ComponentDescriptor> dataValidator;

  /**
   * Test {@link BaseComponentDescriptorService#findById(TenantId, ComponentDescriptorId)}.
   * <ul>
   *   <li>Then return {@link ComponentDescriptor#ComponentDescriptor()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseComponentDescriptorService#findById(TenantId, ComponentDescriptorId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ComponentDescriptor BaseComponentDescriptorService.findById(TenantId, ComponentDescriptorId)"})
  public void testFindById_thenReturnComponentDescriptor() {
    // Arrange
    ComponentDescriptor componentDescriptor = new ComponentDescriptor();
    when(componentDescriptorDao.findById(Mockito.<TenantId>any(), Mockito.<ComponentDescriptorId>any()))
        .thenReturn(componentDescriptor);

    // Act
    ComponentDescriptor actualFindByIdResult = baseComponentDescriptorService.findById(ModelConstants.SYSTEM_TENANT,
        new ComponentDescriptorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(componentDescriptorDao).findById(isA(TenantId.class), isA(ComponentDescriptorId.class));
    assertSame(componentDescriptor, actualFindByIdResult);
  }

  /**
   * Test {@link BaseComponentDescriptorService#findById(TenantId, ComponentDescriptorId)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseComponentDescriptorService#findById(TenantId, ComponentDescriptorId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ComponentDescriptor BaseComponentDescriptorService.findById(TenantId, ComponentDescriptorId)"})
  public void testFindById_thenThrowDataValidationException() {
    // Arrange
    when(componentDescriptorDao.findById(Mockito.<TenantId>any(), Mockito.<ComponentDescriptorId>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseComponentDescriptorService.findById(ModelConstants.SYSTEM_TENANT,
            new ComponentDescriptorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(componentDescriptorDao).findById(isA(TenantId.class), isA(ComponentDescriptorId.class));
  }

  /**
   * Test {@link BaseComponentDescriptorService#findByClazz(TenantId, String)}.
   * <ul>
   *   <li>Then return {@link ComponentDescriptor#ComponentDescriptor()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseComponentDescriptorService#findByClazz(TenantId, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ComponentDescriptor BaseComponentDescriptorService.findByClazz(TenantId, String)"})
  public void testFindByClazz_thenReturnComponentDescriptor() {
    // Arrange
    ComponentDescriptor componentDescriptor = new ComponentDescriptor();
    when(componentDescriptorDao.findByClazz(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(componentDescriptor);

    // Act
    ComponentDescriptor actualFindByClazzResult = baseComponentDescriptorService
        .findByClazz(ModelConstants.SYSTEM_TENANT, "Clazz");

    // Assert
    verify(componentDescriptorDao).findByClazz(isA(TenantId.class), eq("Clazz"));
    assertSame(componentDescriptor, actualFindByClazzResult);
  }

  /**
   * Test {@link BaseComponentDescriptorService#findByClazz(TenantId, String)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseComponentDescriptorService#findByClazz(TenantId, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ComponentDescriptor BaseComponentDescriptorService.findByClazz(TenantId, String)"})
  public void testFindByClazz_thenThrowDataValidationException() {
    // Arrange
    when(componentDescriptorDao.findByClazz(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseComponentDescriptorService.findByClazz(ModelConstants.SYSTEM_TENANT, "Clazz"));
    verify(componentDescriptorDao).findByClazz(isA(TenantId.class), eq("Clazz"));
  }

  /**
   * Test {@link BaseComponentDescriptorService#deleteByClazz(TenantId, String)}.
   * <ul>
   *   <li>Given {@link ComponentDescriptorDao} {@link ComponentDescriptorDao#deleteByClazz(TenantId, String)} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseComponentDescriptorService#deleteByClazz(TenantId, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseComponentDescriptorService.deleteByClazz(TenantId, String)"})
  public void testDeleteByClazz_givenComponentDescriptorDaoDeleteByClazzDoesNothing() {
    // Arrange
    doNothing().when(componentDescriptorDao).deleteByClazz(Mockito.<TenantId>any(), Mockito.<String>any());

    // Act
    baseComponentDescriptorService.deleteByClazz(ModelConstants.SYSTEM_TENANT, "Clazz");

    // Assert
    verify(componentDescriptorDao).deleteByClazz(isA(TenantId.class), eq("Clazz"));
  }

  /**
   * Test {@link BaseComponentDescriptorService#deleteByClazz(TenantId, String)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseComponentDescriptorService#deleteByClazz(TenantId, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseComponentDescriptorService.deleteByClazz(TenantId, String)"})
  public void testDeleteByClazz_thenThrowDataValidationException() {
    // Arrange
    doThrow(new DataValidationException("An error occurred")).when(componentDescriptorDao)
        .deleteByClazz(Mockito.<TenantId>any(), Mockito.<String>any());

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseComponentDescriptorService.deleteByClazz(ModelConstants.SYSTEM_TENANT, "Clazz"));
    verify(componentDescriptorDao).deleteByClazz(isA(TenantId.class), eq("Clazz"));
  }
}
