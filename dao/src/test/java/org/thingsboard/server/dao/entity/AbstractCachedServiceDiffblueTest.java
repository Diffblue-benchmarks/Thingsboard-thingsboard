package org.thingsboard.server.dao.entity;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.cache.TbTransactionalCache;
import org.thingsboard.server.common.data.settings.UserSettings;
import org.thingsboard.server.common.data.settings.UserSettingsCompositeKey;
import org.thingsboard.server.dao.user.UserSettingsDao;
import org.thingsboard.server.dao.user.UserSettingsEvictEvent;
import org.thingsboard.server.dao.user.UserSettingsServiceImpl;

@ContextConfiguration(classes = {UserSettingsServiceImpl.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class AbstractCachedServiceDiffblueTest {
  @Autowired
  private AbstractCachedService<UserSettingsCompositeKey, UserSettings, UserSettingsEvictEvent>
      abstractCachedService;

  @MockBean
  private TbTransactionalCache<UserSettingsCompositeKey, UserSettings> tbTransactionalCache;

  @MockBean private UserSettingsDao userSettingsDao;

  /**
   * Test {@link AbstractCachedService#publishEvictEvent(Object)}.
   *
   * <ul>
   *   <li>Then calls {@link TbTransactionalCache#evict(Serializable)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCachedService#publishEvictEvent(Object)}
   */
  @Test
  @DisplayName("Test publishEvictEvent(Object); then calls evict(Serializable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractCachedService.publishEvictEvent(Object)"})
  void testPublishEvictEvent_thenCallsEvict() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<UserSettingsCompositeKey>any());

    // Act
    abstractCachedService.publishEvictEvent(
        new UserSettingsEvictEvent(new UserSettingsCompositeKey()));

    // Assert
    verify(tbTransactionalCache).evict(isA(UserSettingsCompositeKey.class));
  }
}
