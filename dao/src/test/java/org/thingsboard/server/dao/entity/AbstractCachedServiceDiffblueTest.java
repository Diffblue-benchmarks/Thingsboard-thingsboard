package org.thingsboard.server.dao.entity;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.cache.TbTransactionalCache;
import org.thingsboard.server.common.data.settings.UserSettings;
import org.thingsboard.server.common.data.settings.UserSettingsCompositeKey;
import org.thingsboard.server.dao.user.UserSettingsDao;
import org.thingsboard.server.dao.user.UserSettingsEvictEvent;
import org.thingsboard.server.dao.user.UserSettingsServiceImpl;

@ContextConfiguration(classes = {UserSettingsServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class AbstractCachedServiceDiffblueTest {
  @Autowired
  private AbstractCachedService<UserSettingsCompositeKey, UserSettings, UserSettingsEvictEvent> abstractCachedService;

  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @MockBean
  private TbTransactionalCache<UserSettingsCompositeKey, UserSettings> tbTransactionalCache;

  @MockBean
  private UserSettingsDao userSettingsDao;

  /**
   * Test {@link AbstractCachedService#publishEvictEvent(Object)}.
   * <ul>
   *   <li>Then calls {@link TbTransactionalCache#evict(Serializable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCachedService#publishEvictEvent(Object)}
   */
  @Test
  public void testPublishEvictEvent_thenCallsEvict() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<UserSettingsCompositeKey>any());

    // Act
    abstractCachedService.publishEvictEvent(new UserSettingsEvictEvent(new UserSettingsCompositeKey()));

    // Assert that nothing has changed
    verify(tbTransactionalCache).evict(isA(UserSettingsCompositeKey.class));
  }
}
