package org.thingsboard.server.dao.entity;

import static org.junit.Assert.assertThrows;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.EntityType;

@ContextConfiguration(classes = {DefaultEntityServiceRegistry.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class DefaultEntityServiceRegistryDiffblueTest {
  @Autowired
  private DefaultEntityServiceRegistry defaultEntityServiceRegistry;

  @MockBean
  private EntityDaoService entityDaoService;

  @Autowired
  private List<EntityDaoService> list;

  /**
   * Test {@link DefaultEntityServiceRegistry#getServiceByEntityType(EntityType)}.
   * <p>
   * Method under test:
   * {@link DefaultEntityServiceRegistry#getServiceByEntityType(EntityType)}
   */
  @Test
  public void testGetServiceByEntityType() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultEntityServiceRegistry.getServiceByEntityType(EntityType.TENANT));
  }
}
