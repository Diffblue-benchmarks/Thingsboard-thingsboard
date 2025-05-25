package org.thingsboard.server.dao.sql.query;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class QueryContextDiffblueTest {
  /**
   * Test {@link QueryContext#QueryContext(QuerySecurityContext)}.
   * <p>
   * Method under test: {@link QueryContext#QueryContext(QuerySecurityContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.<init>(QuerySecurityContext)"})
  public void testNewQueryContext() {
    // Arrange and Act
    QueryContext actualQueryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));

    // Assert
    assertEquals("", actualQueryContext.getQuery());
    CustomerId customerId = actualQueryContext.getCustomerId();
    UUID id = customerId.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(0, actualQueryContext.getParameterNames().length);
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    TenantId tenantId = actualQueryContext.getTenantId();
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(EntityType.TENANT, actualQueryContext.getEntityType());
    assertFalse(actualQueryContext.isIgnorePermissionCheck());
    assertTrue(customerId.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(id, tenantId.getId());
  }

  /**
   * Test {@link QueryContext#addParameter(String, Object, int, String)}.
   * <p>
   * Method under test: {@link QueryContext#addParameter(String, Object, int, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addParameter(String, Object, int, String)"})
  public void testAddParameter() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));

    // Act
    queryContext.addParameter("Name", "Value", 2, "Type Name");

    // Assert
    assertArrayEquals(new String[]{"Name"}, queryContext.getParameterNames());
  }

  /**
   * Test {@link QueryContext#addParameter(String, Object, int, String)}.
   * <ul>
   *   <li>Given {@link QueryContext#addParameter(String, Object, int, String)} with {@code Name} and {@code Value} and type is two and {@code Type Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueryContext#addParameter(String, Object, int, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addParameter(String, Object, int, String)"})
  public void testAddParameter_givenAddParameterWithNameAndValueAndTypeIsTwoAndTypeName() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    queryContext.addParameter("Name", "Value", 2, "Type Name");

    // Act
    queryContext.addParameter("Name", "Value", 2, "Type Name");

    // Assert that nothing has changed
    assertArrayEquals(new String[]{"Name"}, queryContext.getParameterNames());
  }

  /**
   * Test {@link QueryContext#addParameter(String, Object, int, String)}.
   * <ul>
   *   <li>Given {@link QueryContext#addParameter(String, Object, int, String)} with {@code Name} and value is {@code null} and type is two and {@code Type Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueryContext#addParameter(String, Object, int, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addParameter(String, Object, int, String)"})
  public void testAddParameter_givenAddParameterWithNameAndValueIsNullAndTypeIsTwoAndTypeName() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    queryContext.addParameter("Name", null, 2, "Type Name");

    // Act
    queryContext.addParameter("Name", "Value", 2, "Type Name");

    // Assert that nothing has changed
    assertArrayEquals(new String[]{"Name"}, queryContext.getParameterNames());
  }

  /**
   * Test {@link QueryContext#addParameter(String, Object, int, String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueryContext#addParameter(String, Object, int, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addParameter(String, Object, int, String)"})
  public void testAddParameter_thenThrowRuntimeException() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    queryContext.addUuidParameter("Name", UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> queryContext.addParameter("Name", "Value", 2, "Type Name"));
  }

  /**
   * Test {@link QueryContext#addParameter(String, Object, int, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueryContext#addParameter(String, Object, int, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addParameter(String, Object, int, String)"})
  public void testAddParameter_whenNull() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));

    // Act
    queryContext.addParameter("Name", null, 2, "Type Name");

    // Assert
    assertArrayEquals(new String[]{"Name"}, queryContext.getParameterNames());
  }

  /**
   * Test {@link QueryContext#append(String)}.
   * <p>
   * Method under test: {@link QueryContext#append(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.append(String)"})
  public void testAppend() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));

    // Act
    queryContext.append("foo");

    // Assert
    assertEquals("foo", queryContext.getQuery());
  }

  /**
   * Test {@link QueryContext#hasValue(String)}.
   * <p>
   * Method under test: {@link QueryContext#hasValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean QueryContext.hasValue(String)"})
  public void testHasValue() {
    // Arrange, Act and Assert
    assertFalse((new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT)))
        .hasValue("Param Name"));
  }

  /**
   * Test {@link QueryContext#getValue(String)}.
   * <p>
   * Method under test: {@link QueryContext#getValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object QueryContext.getValue(String)"})
  public void testGetValue() throws IllegalArgumentException {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT)))
        .getValue("Param Name"));
  }

  /**
   * Test {@link QueryContext#getSqlType(String)}.
   * <p>
   * Method under test: {@link QueryContext#getSqlType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int QueryContext.getSqlType(String)"})
  public void testGetSqlType() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT)))
        .getSqlType("Param Name"));
  }

  /**
   * Test {@link QueryContext#getParameterNames()}.
   * <p>
   * Method under test: {@link QueryContext#getParameterNames()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String[] QueryContext.getParameterNames()"})
  public void testGetParameterNames() {
    // Arrange, Act and Assert
    assertEquals(0, (new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT)))
        .getParameterNames().length);
  }

  /**
   * Test {@link QueryContext#addUuidParameter(String, UUID)}.
   * <p>
   * Method under test: {@link QueryContext#addUuidParameter(String, UUID)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addUuidParameter(String, UUID)"})
  public void testAddUuidParameter() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));

    // Act
    queryContext.addUuidParameter("Name", UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert
    assertArrayEquals(new String[]{"Name"}, queryContext.getParameterNames());
  }

  /**
   * Test {@link QueryContext#addUuidParameter(String, UUID)}.
   * <p>
   * Method under test: {@link QueryContext#addUuidParameter(String, UUID)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addUuidParameter(String, UUID)"})
  public void testAddUuidParameter2() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    queryContext.addUuidParameter("Name", UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    queryContext.addUuidParameter("Name", UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert that nothing has changed
    assertArrayEquals(new String[]{"Name"}, queryContext.getParameterNames());
  }

  /**
   * Test {@link QueryContext#addUuidParameter(String, UUID)}.
   * <p>
   * Method under test: {@link QueryContext#addUuidParameter(String, UUID)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addUuidParameter(String, UUID)"})
  public void testAddUuidParameter3() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    queryContext.addParameter("Name", null, 2, "Type Name");

    // Act
    queryContext.addUuidParameter("Name", UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert that nothing has changed
    assertArrayEquals(new String[]{"Name"}, queryContext.getParameterNames());
  }

  /**
   * Test {@link QueryContext#addUuidParameter(String, UUID)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueryContext#addUuidParameter(String, UUID)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addUuidParameter(String, UUID)"})
  public void testAddUuidParameter_thenThrowRuntimeException() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    queryContext.addParameter("Name", "Value", 2, "Type Name");

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> queryContext.addUuidParameter("Name", UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
  }

  /**
   * Test {@link QueryContext#addUuidParameter(String, UUID)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueryContext#addUuidParameter(String, UUID)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addUuidParameter(String, UUID)"})
  public void testAddUuidParameter_whenNull() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));

    // Act
    queryContext.addUuidParameter("Name", null);

    // Assert
    assertArrayEquals(new String[]{"Name"}, queryContext.getParameterNames());
  }

  /**
   * Test {@link QueryContext#addStringParameter(String, String)}.
   * <p>
   * Method under test: {@link QueryContext#addStringParameter(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addStringParameter(String, String)"})
  public void testAddStringParameter() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));

    // Act
    queryContext.addStringParameter("Name", "42");

    // Assert
    assertArrayEquals(new String[]{"Name"}, queryContext.getParameterNames());
  }

  /**
   * Test {@link QueryContext#addStringParameter(String, String)}.
   * <p>
   * Method under test: {@link QueryContext#addStringParameter(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addStringParameter(String, String)"})
  public void testAddStringParameter2() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    queryContext.addStringParameter("Name", "42");

    // Act
    queryContext.addStringParameter("Name", "42");

    // Assert that nothing has changed
    assertArrayEquals(new String[]{"Name"}, queryContext.getParameterNames());
  }

  /**
   * Test {@link QueryContext#addStringParameter(String, String)}.
   * <p>
   * Method under test: {@link QueryContext#addStringParameter(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addStringParameter(String, String)"})
  public void testAddStringParameter3() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    queryContext.addParameter("Name", null, 2, "VARCHAR");

    // Act
    queryContext.addStringParameter("Name", "42");

    // Assert that nothing has changed
    assertArrayEquals(new String[]{"Name"}, queryContext.getParameterNames());
  }

  /**
   * Test {@link QueryContext#addStringParameter(String, String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueryContext#addStringParameter(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addStringParameter(String, String)"})
  public void testAddStringParameter_thenThrowRuntimeException() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    queryContext.addParameter("Name", "Value", 2, "VARCHAR");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> queryContext.addStringParameter("Name", "42"));
  }

  /**
   * Test {@link QueryContext#addStringParameter(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueryContext#addStringParameter(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addStringParameter(String, String)"})
  public void testAddStringParameter_whenNull() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));

    // Act
    queryContext.addStringParameter("Name", null);

    // Assert
    assertArrayEquals(new String[]{"Name"}, queryContext.getParameterNames());
  }

  /**
   * Test {@link QueryContext#addDoubleParameter(String, double)}.
   * <p>
   * Method under test: {@link QueryContext#addDoubleParameter(String, double)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addDoubleParameter(String, double)"})
  public void testAddDoubleParameter() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));

    // Act
    queryContext.addDoubleParameter("Name", 10.0d);

    // Assert
    assertArrayEquals(new String[]{"Name"}, queryContext.getParameterNames());
  }

  /**
   * Test {@link QueryContext#addDoubleParameter(String, double)}.
   * <p>
   * Method under test: {@link QueryContext#addDoubleParameter(String, double)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addDoubleParameter(String, double)"})
  public void testAddDoubleParameter2() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    queryContext.addDoubleParameter("Name", 10.0d);

    // Act
    queryContext.addDoubleParameter("Name", 10.0d);

    // Assert that nothing has changed
    assertArrayEquals(new String[]{"Name"}, queryContext.getParameterNames());
  }

  /**
   * Test {@link QueryContext#addDoubleParameter(String, double)}.
   * <p>
   * Method under test: {@link QueryContext#addDoubleParameter(String, double)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addDoubleParameter(String, double)"})
  public void testAddDoubleParameter3() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    queryContext.addParameter("Name", null, 2, "DOUBLE");

    // Act
    queryContext.addDoubleParameter("Name", 10.0d);

    // Assert that nothing has changed
    assertArrayEquals(new String[]{"Name"}, queryContext.getParameterNames());
  }

  /**
   * Test {@link QueryContext#addDoubleParameter(String, double)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueryContext#addDoubleParameter(String, double)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addDoubleParameter(String, double)"})
  public void testAddDoubleParameter_thenThrowRuntimeException() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    queryContext.addParameter("Name", "Value", 2, "DOUBLE");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> queryContext.addDoubleParameter("Name", 10.0d));
  }

  /**
   * Test {@link QueryContext#addLongParameter(String, long)}.
   * <p>
   * Method under test: {@link QueryContext#addLongParameter(String, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addLongParameter(String, long)"})
  public void testAddLongParameter() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));

    // Act
    queryContext.addLongParameter("Name", 42L);

    // Assert
    assertArrayEquals(new String[]{"Name"}, queryContext.getParameterNames());
  }

  /**
   * Test {@link QueryContext#addLongParameter(String, long)}.
   * <p>
   * Method under test: {@link QueryContext#addLongParameter(String, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addLongParameter(String, long)"})
  public void testAddLongParameter2() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    queryContext.addLongParameter("Name", 42L);

    // Act
    queryContext.addLongParameter("Name", 42L);

    // Assert that nothing has changed
    assertArrayEquals(new String[]{"Name"}, queryContext.getParameterNames());
  }

  /**
   * Test {@link QueryContext#addLongParameter(String, long)}.
   * <p>
   * Method under test: {@link QueryContext#addLongParameter(String, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addLongParameter(String, long)"})
  public void testAddLongParameter3() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    queryContext.addParameter("Name", null, 2, "BIGINT");

    // Act
    queryContext.addLongParameter("Name", 42L);

    // Assert that nothing has changed
    assertArrayEquals(new String[]{"Name"}, queryContext.getParameterNames());
  }

  /**
   * Test {@link QueryContext#addLongParameter(String, long)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueryContext#addLongParameter(String, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addLongParameter(String, long)"})
  public void testAddLongParameter_thenThrowRuntimeException() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    queryContext.addParameter("Name", "Value", 2, "BIGINT");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> queryContext.addLongParameter("Name", 42L));
  }

  /**
   * Test {@link QueryContext#addStringListParameter(String, List)}.
   * <p>
   * Method under test: {@link QueryContext#addStringListParameter(String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addStringListParameter(String, List)"})
  public void testAddStringListParameter() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    queryContext.addStringListParameter("Name", new ArrayList<>());

    // Act
    queryContext.addStringListParameter("Name", new ArrayList<>());

    // Assert that nothing has changed
    assertArrayEquals(new String[]{"Name"}, queryContext.getParameterNames());
  }

  /**
   * Test {@link QueryContext#addStringListParameter(String, List)}.
   * <p>
   * Method under test: {@link QueryContext#addStringListParameter(String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addStringListParameter(String, List)"})
  public void testAddStringListParameter2() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    queryContext.addParameter("Name", null, 2, "VARCHAR");

    // Act
    queryContext.addStringListParameter("Name", new ArrayList<>());

    // Assert that nothing has changed
    assertArrayEquals(new String[]{"Name"}, queryContext.getParameterNames());
  }

  /**
   * Test {@link QueryContext#addStringListParameter(String, List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueryContext#addStringListParameter(String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addStringListParameter(String, List)"})
  public void testAddStringListParameter_givenFoo_whenArrayListAddFoo() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));

    ArrayList<String> value = new ArrayList<>();
    value.add("foo");
    value.add("VARCHAR");

    // Act
    queryContext.addStringListParameter("Name", value);

    // Assert
    assertArrayEquals(new String[]{"Name"}, queryContext.getParameterNames());
  }

  /**
   * Test {@link QueryContext#addStringListParameter(String, List)}.
   * <ul>
   *   <li>Given {@code VARCHAR}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code VARCHAR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueryContext#addStringListParameter(String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addStringListParameter(String, List)"})
  public void testAddStringListParameter_givenVarchar_whenArrayListAddVarchar() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));

    ArrayList<String> value = new ArrayList<>();
    value.add("VARCHAR");

    // Act
    queryContext.addStringListParameter("Name", value);

    // Assert
    assertArrayEquals(new String[]{"Name"}, queryContext.getParameterNames());
  }

  /**
   * Test {@link QueryContext#addStringListParameter(String, List)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueryContext#addStringListParameter(String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addStringListParameter(String, List)"})
  public void testAddStringListParameter_thenThrowRuntimeException() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    queryContext.addParameter("Name", "Value", 2, "VARCHAR");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> queryContext.addStringListParameter("Name", new ArrayList<>()));
  }

  /**
   * Test {@link QueryContext#addStringListParameter(String, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueryContext#addStringListParameter(String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addStringListParameter(String, List)"})
  public void testAddStringListParameter_whenArrayList() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));

    // Act
    queryContext.addStringListParameter("Name", new ArrayList<>());

    // Assert
    assertArrayEquals(new String[]{"Name"}, queryContext.getParameterNames());
  }

  /**
   * Test {@link QueryContext#addBooleanParameter(String, boolean)}.
   * <p>
   * Method under test: {@link QueryContext#addBooleanParameter(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addBooleanParameter(String, boolean)"})
  public void testAddBooleanParameter() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));

    // Act
    queryContext.addBooleanParameter("Name", true);

    // Assert
    assertArrayEquals(new String[]{"Name"}, queryContext.getParameterNames());
  }

  /**
   * Test {@link QueryContext#addBooleanParameter(String, boolean)}.
   * <p>
   * Method under test: {@link QueryContext#addBooleanParameter(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addBooleanParameter(String, boolean)"})
  public void testAddBooleanParameter2() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    queryContext.addBooleanParameter("Name", true);

    // Act
    queryContext.addBooleanParameter("Name", true);

    // Assert that nothing has changed
    assertArrayEquals(new String[]{"Name"}, queryContext.getParameterNames());
  }

  /**
   * Test {@link QueryContext#addBooleanParameter(String, boolean)}.
   * <p>
   * Method under test: {@link QueryContext#addBooleanParameter(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addBooleanParameter(String, boolean)"})
  public void testAddBooleanParameter3() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    queryContext.addParameter("Name", null, 2, "BOOLEAN");

    // Act
    queryContext.addBooleanParameter("Name", true);

    // Assert that nothing has changed
    assertArrayEquals(new String[]{"Name"}, queryContext.getParameterNames());
  }

  /**
   * Test {@link QueryContext#addBooleanParameter(String, boolean)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueryContext#addBooleanParameter(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addBooleanParameter(String, boolean)"})
  public void testAddBooleanParameter_thenThrowRuntimeException() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    queryContext.addParameter("Name", "Value", 2, "BOOLEAN");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> queryContext.addBooleanParameter("Name", true));
  }

  /**
   * Test {@link QueryContext#addUuidListParameter(String, List)}.
   * <p>
   * Method under test: {@link QueryContext#addUuidListParameter(String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addUuidListParameter(String, List)"})
  public void testAddUuidListParameter() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    queryContext.addStringListParameter("Name", new ArrayList<>());

    // Act
    queryContext.addUuidListParameter("Name", new ArrayList<>());

    // Assert that nothing has changed
    assertArrayEquals(new String[]{"Name"}, queryContext.getParameterNames());
  }

  /**
   * Test {@link QueryContext#addUuidListParameter(String, List)}.
   * <p>
   * Method under test: {@link QueryContext#addUuidListParameter(String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addUuidListParameter(String, List)"})
  public void testAddUuidListParameter2() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    queryContext.addParameter("Name", null, 2, "Type Name");

    // Act
    queryContext.addUuidListParameter("Name", new ArrayList<>());

    // Assert that nothing has changed
    assertArrayEquals(new String[]{"Name"}, queryContext.getParameterNames());
  }

  /**
   * Test {@link QueryContext#addUuidListParameter(String, List)}.
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueryContext#addUuidListParameter(String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addUuidListParameter(String, List)"})
  public void testAddUuidListParameter_givenFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));

    ArrayList<UUID> value = new ArrayList<>();
    value.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    queryContext.addUuidListParameter("Name", value);

    // Assert
    assertArrayEquals(new String[]{"Name"}, queryContext.getParameterNames());
  }

  /**
   * Test {@link QueryContext#addUuidListParameter(String, List)}.
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueryContext#addUuidListParameter(String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addUuidListParameter(String, List)"})
  public void testAddUuidListParameter_givenFromString784f394c42b6435a983cB7beff2784f92() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));

    ArrayList<UUID> value = new ArrayList<>();
    value.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    value.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    queryContext.addUuidListParameter("Name", value);

    // Assert
    assertArrayEquals(new String[]{"Name"}, queryContext.getParameterNames());
  }

  /**
   * Test {@link QueryContext#addUuidListParameter(String, List)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueryContext#addUuidListParameter(String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addUuidListParameter(String, List)"})
  public void testAddUuidListParameter_thenThrowRuntimeException() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    queryContext.addParameter("Name", "Value", 2, "Type Name");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> queryContext.addUuidListParameter("Name", new ArrayList<>()));
  }

  /**
   * Test {@link QueryContext#addUuidListParameter(String, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueryContext#addUuidListParameter(String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryContext.addUuidListParameter(String, List)"})
  public void testAddUuidListParameter_whenArrayList() {
    // Arrange
    QueryContext queryContext = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));

    // Act
    queryContext.addUuidListParameter("Name", new ArrayList<>());

    // Assert
    assertArrayEquals(new String[]{"Name"}, queryContext.getParameterNames());
  }

  /**
   * Test {@link QueryContext#getQuery()}.
   * <p>
   * Method under test: {@link QueryContext#getQuery()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String QueryContext.getQuery()"})
  public void testGetQuery() {
    // Arrange, Act and Assert
    assertEquals("", (new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT)))
        .getQuery());
  }

  /**
   * Test {@link QueryContext#getTenantId()}.
   * <ul>
   *   <li>Then return {@link TenantId#SYS_TENANT_ID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueryContext#getTenantId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TenantId QueryContext.getTenantId()"})
  public void testGetTenantId_thenReturnSys_tenant_id() {
    // Arrange and Act
    TenantId actualTenantId = (new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT)))
        .getTenantId();

    // Assert
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Test {@link QueryContext#getCustomerId()}.
   * <ul>
   *   <li>Then return Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueryContext#getCustomerId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CustomerId QueryContext.getCustomerId()"})
  public void testGetCustomerId_thenReturnIdToStringIs138140001dd211b28080808080808080() {
    // Arrange and Act
    CustomerId actualCustomerId = (new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT)))
        .getCustomerId();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualCustomerId.getId().toString());
    assertEquals(EntityType.CUSTOMER, actualCustomerId.getEntityType());
    assertTrue(actualCustomerId.isNullUid());
  }

  /**
   * Test {@link QueryContext#getEntityType()}.
   * <ul>
   *   <li>Then return {@code TENANT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueryContext#getEntityType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType QueryContext.getEntityType()"})
  public void testGetEntityType_thenReturnTenant() {
    // Arrange, Act and Assert
    assertEquals(EntityType.TENANT, (new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT)))
        .getEntityType());
  }

  /**
   * Test {@link QueryContext#isIgnorePermissionCheck()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueryContext#isIgnorePermissionCheck()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean QueryContext.isIgnorePermissionCheck()"})
  public void testIsIgnorePermissionCheck_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT)))
        .isIgnorePermissionCheck());
  }

  /**
   * Test {@link QueryContext#isIgnorePermissionCheck()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueryContext#isIgnorePermissionCheck()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean QueryContext.isIgnorePermissionCheck()"})
  public void testIsIgnorePermissionCheck_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new QueryContext(new QuerySecurityContext(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT, true))).isIgnorePermissionCheck());
  }
}
