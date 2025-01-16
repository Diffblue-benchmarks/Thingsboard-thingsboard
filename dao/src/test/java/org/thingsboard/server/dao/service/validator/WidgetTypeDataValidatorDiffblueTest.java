package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.widget.BaseWidgetType;
import org.thingsboard.server.common.data.widget.WidgetTypeDetails;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;
import org.thingsboard.server.dao.widget.WidgetTypeDao;
import org.thingsboard.server.dao.widget.WidgetsBundleDao;

@ContextConfiguration(classes = {WidgetTypeDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class WidgetTypeDataValidatorDiffblueTest {
  @MockBean
  private ApiLimitService apiLimitService;

  @MockBean
  private TenantService tenantService;

  @MockBean
  private WidgetTypeDao widgetTypeDao;

  @Autowired
  private WidgetTypeDataValidator widgetTypeDataValidator;

  @MockBean
  private WidgetsBundleDao widgetsBundleDao;

  /**
   * Test
   * {@link WidgetTypeDataValidator#validateDataImpl(TenantId, WidgetTypeDetails)}
   * with {@code TenantId}, {@code WidgetTypeDetails}.
   * <p>
   * Method under test:
   * {@link WidgetTypeDataValidator#validateDataImpl(TenantId, WidgetTypeDetails)}
   */
  @Test
  public void testValidateDataImplWithTenantIdWidgetTypeDetails() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = mock(WidgetTypeDetails.class);
    when(widgetTypeDetails.getDescriptor()).thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    when(widgetTypeDetails.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> widgetTypeDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, widgetTypeDetails));
    verify(widgetTypeDetails).getName();
    verify(widgetTypeDetails, atLeast(1)).getDescriptor();
  }

  /**
   * Test
   * {@link WidgetTypeDataValidator#validateDataImpl(TenantId, WidgetTypeDetails)}
   * with {@code TenantId}, {@code WidgetTypeDetails}.
   * <ul>
   *   <li>Given {@code Widgets type name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeDataValidator#validateDataImpl(TenantId, WidgetTypeDetails)}
   */
  @Test
  public void testValidateDataImplWithTenantIdWidgetTypeDetails_givenWidgetsTypeName() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setName("Widgets type name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> widgetTypeDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, widgetTypeDetails));
  }

  /**
   * Test
   * {@link WidgetTypeDataValidator#validateDataImpl(TenantId, WidgetTypeDetails)}
   * with {@code TenantId}, {@code WidgetTypeDetails}.
   * <ul>
   *   <li>Then calls {@link BaseWidgetType#getTenantId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeDataValidator#validateDataImpl(TenantId, WidgetTypeDetails)}
   */
  @Test
  public void testValidateDataImplWithTenantIdWidgetTypeDetails_thenCallsGetTenantId() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = mock(WidgetTypeDetails.class);
    when(widgetTypeDetails.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(widgetTypeDetails.getDescriptor()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(widgetTypeDetails.getName()).thenReturn("Name");

    // Act
    widgetTypeDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, widgetTypeDetails);

    // Assert that nothing has changed
    verify(widgetTypeDetails).getName();
    verify(widgetTypeDetails, atLeast(1)).getTenantId();
    verify(widgetTypeDetails, atLeast(1)).getDescriptor();
  }

  /**
   * Test
   * {@link WidgetTypeDataValidator#validateDataImpl(TenantId, WidgetTypeDetails)}
   * with {@code TenantId}, {@code WidgetTypeDetails}.
   * <ul>
   *   <li>Then calls {@link ArrayNode#size()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeDataValidator#validateDataImpl(TenantId, WidgetTypeDetails)}
   */
  @Test
  public void testValidateDataImplWithTenantIdWidgetTypeDetails_thenCallsSize() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.size()).thenThrow(new DataValidationException("An error occurred"));
    WidgetTypeDetails widgetTypeDetails = mock(WidgetTypeDetails.class);
    when(widgetTypeDetails.getDescriptor()).thenReturn(arrayNode);
    when(widgetTypeDetails.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> widgetTypeDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, widgetTypeDetails));
    verify(arrayNode).size();
    verify(widgetTypeDetails).getName();
    verify(widgetTypeDetails, atLeast(1)).getDescriptor();
  }

  /**
   * Test
   * {@link WidgetTypeDataValidator#validateCreate(TenantId, WidgetTypeDetails)}
   * with {@code TenantId}, {@code WidgetTypeDetails}.
   * <p>
   * Method under test:
   * {@link WidgetTypeDataValidator#validateCreate(TenantId, WidgetTypeDetails)}
   */
  @Test
  public void testValidateCreateWithTenantIdWidgetTypeDetails() {
    // Arrange
    when(widgetTypeDao.findByTenantIdAndFqn(Mockito.<UUID>any(), Mockito.<String>any())).thenReturn(null);

    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setTenantId(ModelConstants.SYSTEM_TENANT);
    widgetTypeDetails.setName(" ");

    // Act
    widgetTypeDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, widgetTypeDetails);

    // Assert
    verify(widgetTypeDao).findByTenantIdAndFqn(isA(UUID.class), eq("_"));
    assertEquals("_", widgetTypeDetails.getFqn());
  }

  /**
   * Test
   * {@link WidgetTypeDataValidator#validateUpdate(TenantId, WidgetTypeDetails)}
   * with {@code TenantId}, {@code WidgetTypeDetails}.
   * <p>
   * Method under test:
   * {@link WidgetTypeDataValidator#validateUpdate(TenantId, WidgetTypeDetails)}
   */
  @Test
  public void testValidateUpdateWithTenantIdWidgetTypeDetails() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setTenantId(new TenantId(UUID.randomUUID()));
    when(widgetTypeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(widgetTypeDetails);

    WidgetTypeDetails widgetTypeDetails2 = new WidgetTypeDetails();
    widgetTypeDetails2.setTenantId(ModelConstants.SYSTEM_TENANT);
    widgetTypeDetails2.setId(new WidgetTypeId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> widgetTypeDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, widgetTypeDetails2));
    verify(widgetTypeDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link WidgetTypeDataValidator#validateUpdate(TenantId, WidgetTypeDetails)}
   * with {@code TenantId}, {@code WidgetTypeDetails}.
   * <ul>
   *   <li>Given {@link WidgetTypeDetails#WidgetTypeDetails()} Fqn is
   * {@code Fqn}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeDataValidator#validateUpdate(TenantId, WidgetTypeDetails)}
   */
  @Test
  public void testValidateUpdateWithTenantIdWidgetTypeDetails_givenWidgetTypeDetailsFqnIsFqn() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setFqn("Fqn");
    widgetTypeDetails.setTenantId(new TenantId(ModelConstants.NULL_UUID));
    when(widgetTypeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(widgetTypeDetails);

    WidgetTypeDetails widgetTypeDetails2 = new WidgetTypeDetails();
    widgetTypeDetails2.setTenantId(ModelConstants.SYSTEM_TENANT);
    widgetTypeDetails2.setId(new WidgetTypeId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> widgetTypeDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, widgetTypeDetails2));
    verify(widgetTypeDao).findById(isA(TenantId.class), isA(UUID.class));
  }
}
