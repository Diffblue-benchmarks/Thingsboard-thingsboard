package org.thingsboard.server.dao.sql.mobile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.EntityManagerFactory;
import java.util.UUID;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.mobile.MobileAppSettings;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.MobileAppSettingsEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaMobileAppSettingsDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaMobileAppSettingsDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaMobileAppSettingsDao jpaMobileAppSettingsDao;

  @MockBean
  private MobileAppSettingsRepository mobileAppSettingsRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test {@link JpaMobileAppSettingsDao#findByTenantId(TenantId)}.
   * <ul>
   *   <li>Then return {@link MobileAppSettings#MobileAppSettings()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaMobileAppSettingsDao#findByTenantId(TenantId)}
   */
  @Test
  public void testFindByTenantId_thenReturnMobileAppSettings() {
    // Arrange
    MobileAppSettingsEntity mobileAppSettingsEntity = mock(MobileAppSettingsEntity.class);
    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    when(mobileAppSettingsEntity.toData()).thenReturn(mobileAppSettings);
    doNothing().when(mobileAppSettingsEntity).setCreatedTime(anyLong());
    doNothing().when(mobileAppSettingsEntity).setId(Mockito.<UUID>any());
    doNothing().when(mobileAppSettingsEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(mobileAppSettingsEntity).setAndroidConfig(Mockito.<JsonNode>any());
    doNothing().when(mobileAppSettingsEntity).setIosConfig(Mockito.<JsonNode>any());
    doNothing().when(mobileAppSettingsEntity).setQrCodeConfig(Mockito.<JsonNode>any());
    doNothing().when(mobileAppSettingsEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(mobileAppSettingsEntity).setUseDefaultApp(anyBoolean());
    mobileAppSettingsEntity.setAndroidConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setCreatedTime(1L);
    mobileAppSettingsEntity.setId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity.setIosConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setQrCodeConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    mobileAppSettingsEntity.setTenantId(ModelConstants.NULL_UUID);
    mobileAppSettingsEntity.setUseDefaultApp(true);
    mobileAppSettingsEntity.setUuid(ModelConstants.NULL_UUID);
    when(mobileAppSettingsRepository.findByTenantId(Mockito.<UUID>any())).thenReturn(mobileAppSettingsEntity);

    // Act
    MobileAppSettings actualFindByTenantIdResult = jpaMobileAppSettingsDao.findByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(mobileAppSettingsEntity).setCreatedTime(eq(1L));
    verify(mobileAppSettingsEntity).setId(isA(UUID.class));
    verify(mobileAppSettingsEntity).setUuid(isA(UUID.class));
    verify(mobileAppSettingsEntity).setAndroidConfig(isA(JsonNode.class));
    verify(mobileAppSettingsEntity).setIosConfig(isA(JsonNode.class));
    verify(mobileAppSettingsEntity).setQrCodeConfig(isA(JsonNode.class));
    verify(mobileAppSettingsEntity).setTenantId(isA(UUID.class));
    verify(mobileAppSettingsEntity).setUseDefaultApp(eq(true));
    verify(mobileAppSettingsEntity).toData();
    verify(mobileAppSettingsRepository).findByTenantId(isA(UUID.class));
    assertSame(mobileAppSettings, actualFindByTenantIdResult);
  }

  /**
   * Test {@link JpaMobileAppSettingsDao#removeByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then calls
   * {@link MobileAppSettingsRepository#deleteByTenantId(UUID)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaMobileAppSettingsDao#removeByTenantId(TenantId)}
   */
  @Test
  public void testRemoveByTenantId_whenSystem_tenant_thenCallsDeleteByTenantId() {
    // Arrange
    doNothing().when(mobileAppSettingsRepository).deleteByTenantId(Mockito.<UUID>any());

    // Act
    jpaMobileAppSettingsDao.removeByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert that nothing has changed
    verify(mobileAppSettingsRepository).deleteByTenantId(isA(UUID.class));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaMobileAppSettingsDao#getEntityClass()}
   *   <li>{@link JpaMobileAppSettingsDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaMobileAppSettingsDao jpaMobileAppSettingsDao = new JpaMobileAppSettingsDao();

    // Act
    Class<MobileAppSettingsEntity> actualEntityClass = jpaMobileAppSettingsDao.getEntityClass();

    // Assert
    assertNull(jpaMobileAppSettingsDao.getRepository());
    Class<MobileAppSettingsEntity> expectedEntityClass = MobileAppSettingsEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
