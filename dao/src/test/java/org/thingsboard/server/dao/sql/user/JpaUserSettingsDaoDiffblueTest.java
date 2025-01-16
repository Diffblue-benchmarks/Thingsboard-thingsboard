package org.thingsboard.server.dao.sql.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.settings.UserSettings;
import org.thingsboard.server.common.data.settings.UserSettingsCompositeKey;
import org.thingsboard.server.common.data.settings.UserSettingsType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.UserSettingsEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaUserSettingsDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaUserSettingsDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaUserSettingsDao jpaUserSettingsDao;

  @MockBean
  private TransactionTemplate transactionTemplate;

  @MockBean
  private UserSettingsRepository userSettingsRepository;

  /**
   * Test {@link JpaUserSettingsDao#save(TenantId, UserSettings)}.
   * <ul>
   *   <li>Given {@link UserId} {@link UUIDBased#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaUserSettingsDao#save(TenantId, UserSettings)}
   */
  @Test
  public void testSave_givenUserIdGetIdReturnNull_uuid_thenCallsGetId() throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = mock(UserSettings.class);
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    UserSettingsEntity userSettingsEntity = mock(UserSettingsEntity.class);
    when(userSettingsEntity.toData()).thenReturn(userSettings);
    doNothing().when(userSettingsEntity).setSettings(Mockito.<JsonNode>any());
    doNothing().when(userSettingsEntity).setType(Mockito.<String>any());
    doNothing().when(userSettingsEntity).setUserId(Mockito.<UUID>any());
    userSettingsEntity.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity.setType("Type");
    userSettingsEntity.setUserId(ModelConstants.NULL_UUID);
    when(userSettingsRepository.save(Mockito.<UserSettingsEntity>any())).thenReturn(userSettingsEntity);
    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);
    UserSettings userSettings2 = mock(UserSettings.class);
    when(userSettings2.getSettings()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(userSettings2.getType()).thenReturn(UserSettingsType.GENERAL);
    when(userSettings2.getUserId()).thenReturn(userId);
    doNothing().when(userSettings2).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings2).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings2).setType(Mockito.<UserSettingsType>any());
    userSettings2.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings2.setType(UserSettingsType.GENERAL);
    userSettings2.setUserId(null);

    // Act
    jpaUserSettingsDao.save(ModelConstants.SYSTEM_TENANT, userSettings2);

    // Assert
    verify(userSettingsRepository).save(isA(UserSettingsEntity.class));
    verify(userId).getId();
    verify(userSettings2, atLeast(1)).getSettings();
    verify(userSettings2).getType();
    verify(userSettings2).getUserId();
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings2).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings2).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettings2).setUserId(isNull());
    verify(userSettingsEntity).setSettings(isA(JsonNode.class));
    verify(userSettingsEntity).setType(eq("Type"));
    verify(userSettingsEntity).setUserId(isA(UUID.class));
    verify(userSettingsEntity).toData();
  }

  /**
   * Test {@link JpaUserSettingsDao#save(TenantId, UserSettings)}.
   * <ul>
   *   <li>Given {@link UserSettings} {@link UserSettings#setUserId(UserId)} does
   * nothing.</li>
   *   <li>Then calls {@link CrudRepository#save(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaUserSettingsDao#save(TenantId, UserSettings)}
   */
  @Test
  public void testSave_givenUserSettingsSetUserIdDoesNothing_thenCallsSave() throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = mock(UserSettings.class);
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    UserSettingsEntity userSettingsEntity = mock(UserSettingsEntity.class);
    when(userSettingsEntity.toData()).thenReturn(userSettings);
    doNothing().when(userSettingsEntity).setSettings(Mockito.<JsonNode>any());
    doNothing().when(userSettingsEntity).setType(Mockito.<String>any());
    doNothing().when(userSettingsEntity).setUserId(Mockito.<UUID>any());
    userSettingsEntity.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity.setType("Type");
    userSettingsEntity.setUserId(ModelConstants.NULL_UUID);
    when(userSettingsRepository.save(Mockito.<UserSettingsEntity>any())).thenReturn(userSettingsEntity);
    UserSettings userSettings2 = mock(UserSettings.class);
    when(userSettings2.getSettings()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(userSettings2.getType()).thenReturn(UserSettingsType.GENERAL);
    when(userSettings2.getUserId()).thenReturn(new UserId(ModelConstants.NULL_UUID));
    doNothing().when(userSettings2).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings2).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings2).setType(Mockito.<UserSettingsType>any());
    userSettings2.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings2.setType(UserSettingsType.GENERAL);
    userSettings2.setUserId(null);

    // Act
    jpaUserSettingsDao.save(ModelConstants.SYSTEM_TENANT, userSettings2);

    // Assert
    verify(userSettingsRepository).save(isA(UserSettingsEntity.class));
    verify(userSettings2, atLeast(1)).getSettings();
    verify(userSettings2).getType();
    verify(userSettings2).getUserId();
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings2).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings2).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettings2).setUserId(isNull());
    verify(userSettingsEntity).setSettings(isA(JsonNode.class));
    verify(userSettingsEntity).setType(eq("Type"));
    verify(userSettingsEntity).setUserId(isA(UUID.class));
    verify(userSettingsEntity).toData();
  }

  /**
   * Test {@link JpaUserSettingsDao#findById(TenantId, UserSettingsCompositeKey)}.
   * <ul>
   *   <li>Given {@link UserSettingsRepository}
   * {@link CrudRepository#findById(Object)} return empty.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaUserSettingsDao#findById(TenantId, UserSettingsCompositeKey)}
   */
  @Test
  public void testFindById_givenUserSettingsRepositoryFindByIdReturnEmpty_thenReturnNull() {
    // Arrange
    Optional<UserSettingsEntity> emptyResult = Optional.empty();
    when(userSettingsRepository.findById(Mockito.<UserSettingsCompositeKey>any())).thenReturn(emptyResult);

    // Act
    UserSettings actualFindByIdResult = jpaUserSettingsDao.findById(ModelConstants.SYSTEM_TENANT,
        new UserSettingsCompositeKey());

    // Assert
    verify(userSettingsRepository).findById(isA(UserSettingsCompositeKey.class));
    assertNull(actualFindByIdResult);
  }

  /**
   * Test {@link JpaUserSettingsDao#findById(TenantId, UserSettingsCompositeKey)}.
   * <ul>
   *   <li>Given {@link UserSettings} {@link UserSettings#setUserId(UserId)} does
   * nothing.</li>
   *   <li>Then calls {@link UserSettings#setSettingsBytes(byte[])}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaUserSettingsDao#findById(TenantId, UserSettingsCompositeKey)}
   */
  @Test
  public void testFindById_givenUserSettingsSetUserIdDoesNothing_thenCallsSetSettingsBytes()
      throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = mock(UserSettings.class);
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    UserSettingsEntity userSettingsEntity = mock(UserSettingsEntity.class);
    when(userSettingsEntity.toData()).thenReturn(userSettings);
    doNothing().when(userSettingsEntity).setSettings(Mockito.<JsonNode>any());
    doNothing().when(userSettingsEntity).setType(Mockito.<String>any());
    doNothing().when(userSettingsEntity).setUserId(Mockito.<UUID>any());
    userSettingsEntity.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity.setType("Type");
    userSettingsEntity.setUserId(ModelConstants.NULL_UUID);
    Optional<UserSettingsEntity> ofResult = Optional.of(userSettingsEntity);
    when(userSettingsRepository.findById(Mockito.<UserSettingsCompositeKey>any())).thenReturn(ofResult);

    // Act
    jpaUserSettingsDao.findById(ModelConstants.SYSTEM_TENANT, new UserSettingsCompositeKey());

    // Assert
    verify(userSettingsRepository).findById(isA(UserSettingsCompositeKey.class));
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsEntity).setSettings(isA(JsonNode.class));
    verify(userSettingsEntity).setType(eq("Type"));
    verify(userSettingsEntity).setUserId(isA(UUID.class));
    verify(userSettingsEntity).toData();
  }

  /**
   * Test
   * {@link JpaUserSettingsDao#removeById(TenantId, UserSettingsCompositeKey)}.
   * <p>
   * Method under test:
   * {@link JpaUserSettingsDao#removeById(TenantId, UserSettingsCompositeKey)}
   */
  @Test
  public void testRemoveById() {
    // Arrange
    doNothing().when(userSettingsRepository).deleteById(Mockito.<UserSettingsCompositeKey>any());

    // Act
    jpaUserSettingsDao.removeById(ModelConstants.SYSTEM_TENANT, new UserSettingsCompositeKey());

    // Assert that nothing has changed
    verify(userSettingsRepository).deleteById(isA(UserSettingsCompositeKey.class));
  }

  /**
   * Test {@link JpaUserSettingsDao#removeByUserId(TenantId, UserId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link UserId} {@link UUIDBased#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaUserSettingsDao#removeByUserId(TenantId, UserId)}
   */
  @Test
  public void testRemoveByUserId_givenNull_uuid_whenUserIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(userSettingsRepository).deleteByUserId(Mockito.<UUID>any());
    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    jpaUserSettingsDao.removeByUserId(ModelConstants.SYSTEM_TENANT, userId);

    // Assert that nothing has changed
    verify(userId).getId();
    verify(userSettingsRepository).deleteByUserId(isA(UUID.class));
  }

  /**
   * Test {@link JpaUserSettingsDao#removeByUserId(TenantId, UserId)}.
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UserSettingsRepository#deleteByUserId(UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaUserSettingsDao#removeByUserId(TenantId, UserId)}
   */
  @Test
  public void testRemoveByUserId_whenUserIdWithIdIsNull_uuid_thenCallsDeleteByUserId() {
    // Arrange
    doNothing().when(userSettingsRepository).deleteByUserId(Mockito.<UUID>any());

    // Act
    jpaUserSettingsDao.removeByUserId(ModelConstants.SYSTEM_TENANT, new UserId(ModelConstants.NULL_UUID));

    // Assert that nothing has changed
    verify(userSettingsRepository).deleteByUserId(isA(UUID.class));
  }

  /**
   * Test
   * {@link JpaUserSettingsDao#findByTypeAndPath(TenantId, UserSettingsType, String[])}.
   * <ul>
   *   <li>Given {@link UserSettings} {@link UserSettings#setUserId(UserId)} does
   * nothing.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaUserSettingsDao#findByTypeAndPath(TenantId, UserSettingsType, String[])}
   */
  @Test
  public void testFindByTypeAndPath_givenUserSettingsSetUserIdDoesNothing_thenReturnSizeIsOne()
      throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = mock(UserSettings.class);
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    UserSettingsEntity userSettingsEntity = mock(UserSettingsEntity.class);
    when(userSettingsEntity.toData()).thenReturn(userSettings);
    doNothing().when(userSettingsEntity).setSettings(Mockito.<JsonNode>any());
    doNothing().when(userSettingsEntity).setType(Mockito.<String>any());
    doNothing().when(userSettingsEntity).setUserId(Mockito.<UUID>any());
    userSettingsEntity.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity.setType("findByTypeAndPath [{}][{}][{}]");
    userSettingsEntity.setUserId(ModelConstants.NULL_UUID);

    ArrayList<UserSettingsEntity> userSettingsEntityList = new ArrayList<>();
    userSettingsEntityList.add(userSettingsEntity);
    when(userSettingsRepository.findByTypeAndPathExisting(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(userSettingsEntityList);

    // Act
    List<UserSettings> actualFindByTypeAndPathResult = jpaUserSettingsDao
        .findByTypeAndPath(ModelConstants.SYSTEM_TENANT, UserSettingsType.GENERAL, "Path");

    // Assert
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsEntity).setSettings(isA(JsonNode.class));
    verify(userSettingsEntity).setType(eq("findByTypeAndPath [{}][{}][{}]"));
    verify(userSettingsEntity).setUserId(isA(UUID.class));
    verify(userSettingsEntity).toData();
    verify(userSettingsRepository).findByTypeAndPathExisting(eq("GENERAL"), isA(String[].class));
    assertEquals(1, actualFindByTypeAndPathResult.size());
  }

  /**
   * Test
   * {@link JpaUserSettingsDao#findByTypeAndPath(TenantId, UserSettingsType, String[])}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaUserSettingsDao#findByTypeAndPath(TenantId, UserSettingsType, String[])}
   */
  @Test
  public void testFindByTypeAndPath_thenReturnEmpty() {
    // Arrange
    when(userSettingsRepository.findByTypeAndPathExisting(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<UserSettings> actualFindByTypeAndPathResult = jpaUserSettingsDao
        .findByTypeAndPath(ModelConstants.SYSTEM_TENANT, UserSettingsType.GENERAL, "Path");

    // Assert
    verify(userSettingsRepository).findByTypeAndPathExisting(eq("GENERAL"), isA(String[].class));
    assertTrue(actualFindByTypeAndPathResult.isEmpty());
  }
}
