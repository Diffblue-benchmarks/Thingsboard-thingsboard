package org.thingsboard.server.dao.sql.user;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.EntityManagerFactory;
import java.util.LinkedHashMap;
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
import org.thingsboard.server.common.data.BaseData;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.id.UserAuthSettingsId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.security.UserAuthSettings;
import org.thingsboard.server.common.data.security.model.mfa.account.AccountTwoFaSettings;
import org.thingsboard.server.common.data.security.model.mfa.account.TwoFaAccountConfig;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.UserAuthSettingsEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaUserAuthSettingsDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaUserAuthSettingsDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaUserAuthSettingsDao jpaUserAuthSettingsDao;

  @MockBean
  private TransactionTemplate transactionTemplate;

  @MockBean
  private UserAuthSettingsRepository userAuthSettingsRepository;

  /**
   * Test {@link JpaUserAuthSettingsDao#findByUserId(UserId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link UserId} {@link UUIDBased#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaUserAuthSettingsDao#findByUserId(UserId)}
   */
  @Test
  public void testFindByUserId_givenNull_uuid_whenUserIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    AccountTwoFaSettings twoFaSettings = mock(AccountTwoFaSettings.class);
    doNothing().when(twoFaSettings).setConfigs(Mockito.<LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig>>any());
    twoFaSettings.setConfigs(new LinkedHashMap<>());
    UserAuthSettings userAuthSettings = mock(UserAuthSettings.class);
    doNothing().when(userAuthSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userAuthSettings).setCreatedTime(anyLong());
    doNothing().when(userAuthSettings).setId(Mockito.<UserAuthSettingsId>any());
    doNothing().when(userAuthSettings).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(new UserAuthSettingsId(ModelConstants.NULL_UUID));
    userAuthSettings.setTwoFaSettings(twoFaSettings);
    userAuthSettings.setUserId(null);
    UserAuthSettingsEntity userAuthSettingsEntity = mock(UserAuthSettingsEntity.class);
    when(userAuthSettingsEntity.toData()).thenReturn(userAuthSettings);
    doNothing().when(userAuthSettingsEntity).setCreatedTime(anyLong());
    doNothing().when(userAuthSettingsEntity).setId(Mockito.<UUID>any());
    doNothing().when(userAuthSettingsEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(userAuthSettingsEntity).setTwoFaSettings(Mockito.<JsonNode>any());
    doNothing().when(userAuthSettingsEntity).setUserId(Mockito.<UUID>any());
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setTwoFaSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setUuid(ModelConstants.NULL_UUID);
    when(userAuthSettingsRepository.findByUserId(Mockito.<UUID>any())).thenReturn(userAuthSettingsEntity);
    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    jpaUserAuthSettingsDao.findByUserId(userId);

    // Assert
    verify(userAuthSettings).setCreatedTime(eq(1L));
    verify(userAuthSettings).setId(isA(UserAuthSettingsId.class));
    verify(userId).getId();
    verify(userAuthSettings).setTwoFaSettings(isA(AccountTwoFaSettings.class));
    verify(userAuthSettings).setUserId(isNull());
    verify(twoFaSettings).setConfigs(isA(LinkedHashMap.class));
    verify(userAuthSettingsEntity).setCreatedTime(eq(1L));
    verify(userAuthSettingsEntity).setId(isA(UUID.class));
    verify(userAuthSettingsEntity).setUuid(isA(UUID.class));
    verify(userAuthSettingsEntity).setTwoFaSettings(isA(JsonNode.class));
    verify(userAuthSettingsEntity).setUserId(isA(UUID.class));
    verify(userAuthSettingsEntity).toData();
    verify(userAuthSettingsRepository).findByUserId(isA(UUID.class));
  }

  /**
   * Test {@link JpaUserAuthSettingsDao#findByUserId(UserId)}.
   * <ul>
   *   <li>Then calls {@link BaseData#setCreatedTime(long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaUserAuthSettingsDao#findByUserId(UserId)}
   */
  @Test
  public void testFindByUserId_thenCallsSetCreatedTime() {
    // Arrange
    AccountTwoFaSettings twoFaSettings = mock(AccountTwoFaSettings.class);
    doNothing().when(twoFaSettings).setConfigs(Mockito.<LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig>>any());
    twoFaSettings.setConfigs(new LinkedHashMap<>());
    UserAuthSettings userAuthSettings = mock(UserAuthSettings.class);
    doNothing().when(userAuthSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userAuthSettings).setCreatedTime(anyLong());
    doNothing().when(userAuthSettings).setId(Mockito.<UserAuthSettingsId>any());
    doNothing().when(userAuthSettings).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(new UserAuthSettingsId(ModelConstants.NULL_UUID));
    userAuthSettings.setTwoFaSettings(twoFaSettings);
    userAuthSettings.setUserId(null);
    UserAuthSettingsEntity userAuthSettingsEntity = mock(UserAuthSettingsEntity.class);
    when(userAuthSettingsEntity.toData()).thenReturn(userAuthSettings);
    doNothing().when(userAuthSettingsEntity).setCreatedTime(anyLong());
    doNothing().when(userAuthSettingsEntity).setId(Mockito.<UUID>any());
    doNothing().when(userAuthSettingsEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(userAuthSettingsEntity).setTwoFaSettings(Mockito.<JsonNode>any());
    doNothing().when(userAuthSettingsEntity).setUserId(Mockito.<UUID>any());
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setTwoFaSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setUuid(ModelConstants.NULL_UUID);
    when(userAuthSettingsRepository.findByUserId(Mockito.<UUID>any())).thenReturn(userAuthSettingsEntity);

    // Act
    jpaUserAuthSettingsDao.findByUserId(new UserId(ModelConstants.NULL_UUID));

    // Assert
    verify(userAuthSettings).setCreatedTime(eq(1L));
    verify(userAuthSettings).setId(isA(UserAuthSettingsId.class));
    verify(userAuthSettings).setTwoFaSettings(isA(AccountTwoFaSettings.class));
    verify(userAuthSettings).setUserId(isNull());
    verify(twoFaSettings).setConfigs(isA(LinkedHashMap.class));
    verify(userAuthSettingsEntity).setCreatedTime(eq(1L));
    verify(userAuthSettingsEntity).setId(isA(UUID.class));
    verify(userAuthSettingsEntity).setUuid(isA(UUID.class));
    verify(userAuthSettingsEntity).setTwoFaSettings(isA(JsonNode.class));
    verify(userAuthSettingsEntity).setUserId(isA(UUID.class));
    verify(userAuthSettingsEntity).toData();
    verify(userAuthSettingsRepository).findByUserId(isA(UUID.class));
  }

  /**
   * Test {@link JpaUserAuthSettingsDao#removeByUserId(UserId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link UserId} {@link UUIDBased#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaUserAuthSettingsDao#removeByUserId(UserId)}
   */
  @Test
  public void testRemoveByUserId_givenNull_uuid_whenUserIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(userAuthSettingsRepository).deleteByUserId(Mockito.<UUID>any());
    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    jpaUserAuthSettingsDao.removeByUserId(userId);

    // Assert that nothing has changed
    verify(userId).getId();
    verify(userAuthSettingsRepository).deleteByUserId(isA(UUID.class));
  }

  /**
   * Test {@link JpaUserAuthSettingsDao#removeByUserId(UserId)}.
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UserAuthSettingsRepository#deleteByUserId(UUID)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaUserAuthSettingsDao#removeByUserId(UserId)}
   */
  @Test
  public void testRemoveByUserId_whenUserIdWithIdIsNull_uuid_thenCallsDeleteByUserId() {
    // Arrange
    doNothing().when(userAuthSettingsRepository).deleteByUserId(Mockito.<UUID>any());

    // Act
    jpaUserAuthSettingsDao.removeByUserId(new UserId(ModelConstants.NULL_UUID));

    // Assert that nothing has changed
    verify(userAuthSettingsRepository).deleteByUserId(isA(UUID.class));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaUserAuthSettingsDao#getEntityClass()}
   *   <li>{@link JpaUserAuthSettingsDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaUserAuthSettingsDao jpaUserAuthSettingsDao = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));

    // Act
    Class<UserAuthSettingsEntity> actualEntityClass = jpaUserAuthSettingsDao.getEntityClass();
    jpaUserAuthSettingsDao.getRepository();

    // Assert
    Class<UserAuthSettingsEntity> expectedEntityClass = UserAuthSettingsEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
