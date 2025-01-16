package org.thingsboard.server.dao.sql.component;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import jakarta.persistence.EntityManagerFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.id.ComponentDescriptorId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.plugin.ComponentClusteringMode;
import org.thingsboard.server.common.data.plugin.ComponentDescriptor;
import org.thingsboard.server.common.data.plugin.ComponentScope;
import org.thingsboard.server.common.data.plugin.ComponentType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.ComponentDescriptorEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaBaseComponentDescriptorDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaBaseComponentDescriptorDaoDiffblueTest {
  @MockBean
  private ComponentDescriptorInsertRepository componentDescriptorInsertRepository;

  @MockBean
  private ComponentDescriptorRepository componentDescriptorRepository;

  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private JpaBaseComponentDescriptorDao jpaBaseComponentDescriptorDao;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaBaseComponentDescriptorDao#getEntityClass()}
   *   <li>{@link JpaBaseComponentDescriptorDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaBaseComponentDescriptorDao jpaBaseComponentDescriptorDao = new JpaBaseComponentDescriptorDao();

    // Act
    Class<ComponentDescriptorEntity> actualEntityClass = jpaBaseComponentDescriptorDao.getEntityClass();

    // Assert
    assertNull(jpaBaseComponentDescriptorDao.getRepository());
    Class<ComponentDescriptorEntity> expectedEntityClass = ComponentDescriptorEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test
   * {@link JpaBaseComponentDescriptorDao#saveIfNotExist(TenantId, ComponentDescriptor)}.
   * <p>
   * Method under test:
   * {@link JpaBaseComponentDescriptorDao#saveIfNotExist(TenantId, ComponentDescriptor)}
   */
  @Test
  public void testSaveIfNotExist() {
    // Arrange
    when(componentDescriptorRepository.existsById(Mockito.<UUID>any())).thenReturn(true);
    ComponentDescriptor component = new ComponentDescriptor(new ComponentDescriptorId(ModelConstants.NULL_UUID));

    // Act
    Optional<ComponentDescriptor> actualSaveIfNotExistResult = jpaBaseComponentDescriptorDao
        .saveIfNotExist(ModelConstants.SYSTEM_TENANT, component);

    // Assert
    verify(componentDescriptorRepository).existsById(isA(UUID.class));
    UUID uuidId = component.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals(0L, component.getCreatedTime());
    assertFalse(actualSaveIfNotExistResult.isPresent());
    assertSame(uuidId, component.getId().getId());
  }

  /**
   * Test
   * {@link JpaBaseComponentDescriptorDao#saveIfNotExist(TenantId, ComponentDescriptor)}.
   * <ul>
   *   <li>Then {@link Optional#get()} ConfigurationDescriptor iterator next return
   * {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaBaseComponentDescriptorDao#saveIfNotExist(TenantId, ComponentDescriptor)}
   */
  @Test
  public void testSaveIfNotExist_thenGetConfigurationDescriptorIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);
    when(componentDescriptorInsertRepository.saveOrUpdate(Mockito.<ComponentDescriptorEntity>any()))
        .thenReturn(componentDescriptorEntity);
    when(componentDescriptorRepository.existsById(Mockito.<UUID>any())).thenReturn(false);

    // Act
    Optional<ComponentDescriptor> actualSaveIfNotExistResult = jpaBaseComponentDescriptorDao
        .saveIfNotExist(ModelConstants.SYSTEM_TENANT, new ComponentDescriptor());

    // Assert
    verify(componentDescriptorRepository).existsById(isA(UUID.class));
    verify(componentDescriptorInsertRepository).saveOrUpdate(isA(ComponentDescriptorEntity.class));
    ComponentDescriptor getResult = actualSaveIfNotExistResult.get();
    JsonNode configurationDescriptor = getResult.getConfigurationDescriptor();
    Iterator<JsonNode> iteratorResult = configurationDescriptor.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(configurationDescriptor instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = configurationDescriptor.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    UUID uuidId = getResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("Actions", getResult.getActions());
    assertEquals("Clazz", getResult.getClazz());
    assertEquals("Name", getResult.getName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", configurationDescriptor.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(1, configurationDescriptor.size());
    assertEquals(1, getResult.getConfigurationVersion());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, configurationDescriptor.getNodeType());
    assertEquals(ComponentClusteringMode.USER_PREFERENCE, getResult.getClusteringMode());
    assertEquals(ComponentScope.SYSTEM, getResult.getScope());
    assertEquals(ComponentType.ENRICHMENT, getResult.getType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(configurationDescriptor.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(configurationDescriptor.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(configurationDescriptor.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(configurationDescriptor.isBinary());
    assertFalse(configurationDescriptor.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(configurationDescriptor.isDouble());
    assertFalse(configurationDescriptor.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(configurationDescriptor.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(configurationDescriptor.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(configurationDescriptor.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(configurationDescriptor.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(configurationDescriptor.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(configurationDescriptor.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(configurationDescriptor.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(configurationDescriptor.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(configurationDescriptor.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(configurationDescriptor.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(configurationDescriptor.isTextual());
    assertFalse(configurationDescriptor.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(configurationDescriptor.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(configurationDescriptor.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(getResult.isHasQueueName());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(uuidId, getResult.getId().getId());
  }

  /**
   * Test
   * {@link JpaBaseComponentDescriptorDao#saveIfNotExist(TenantId, ComponentDescriptor)}.
   * <ul>
   *   <li>Then return {@link Optional#get()} is
   * {@link ComponentDescriptor#ComponentDescriptor()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaBaseComponentDescriptorDao#saveIfNotExist(TenantId, ComponentDescriptor)}
   */
  @Test
  public void testSaveIfNotExist_thenReturnGetIsComponentDescriptor() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = mock(ComponentDescriptorEntity.class);
    ComponentDescriptor componentDescriptor = new ComponentDescriptor();
    when(componentDescriptorEntity.toData()).thenReturn(componentDescriptor);
    doNothing().when(componentDescriptorEntity).setCreatedTime(anyLong());
    doNothing().when(componentDescriptorEntity).setId(Mockito.<UUID>any());
    doNothing().when(componentDescriptorEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(componentDescriptorEntity).setActions(Mockito.<String>any());
    doNothing().when(componentDescriptorEntity).setClazz(Mockito.<String>any());
    doNothing().when(componentDescriptorEntity).setClusteringMode(Mockito.<ComponentClusteringMode>any());
    doNothing().when(componentDescriptorEntity).setConfigurationDescriptor(Mockito.<JsonNode>any());
    doNothing().when(componentDescriptorEntity).setConfigurationVersion(anyInt());
    doNothing().when(componentDescriptorEntity).setHasQueueName(anyBoolean());
    doNothing().when(componentDescriptorEntity).setName(Mockito.<String>any());
    doNothing().when(componentDescriptorEntity).setScope(Mockito.<ComponentScope>any());
    doNothing().when(componentDescriptorEntity).setType(Mockito.<ComponentType>any());
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);
    when(componentDescriptorInsertRepository.saveOrUpdate(Mockito.<ComponentDescriptorEntity>any()))
        .thenReturn(componentDescriptorEntity);
    when(componentDescriptorRepository.existsById(Mockito.<UUID>any())).thenReturn(false);
    ComponentDescriptor component = mock(ComponentDescriptor.class);
    when(component.isHasQueueName()).thenReturn(true);
    when(component.getConfigurationDescriptor()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(component.getConfigurationVersion()).thenReturn(1);
    when(component.getActions()).thenReturn("Actions");
    when(component.getClazz()).thenReturn("Clazz");
    when(component.getName()).thenReturn("Name");
    when(component.getCreatedTime()).thenReturn(1L);
    when(component.getClusteringMode()).thenReturn(ComponentClusteringMode.USER_PREFERENCE);
    when(component.getScope()).thenReturn(ComponentScope.SYSTEM);
    when(component.getType()).thenReturn(ComponentType.ENRICHMENT);
    when(component.getId()).thenReturn(new ComponentDescriptorId(ModelConstants.NULL_UUID));

    // Act
    Optional<ComponentDescriptor> actualSaveIfNotExistResult = jpaBaseComponentDescriptorDao
        .saveIfNotExist(ModelConstants.SYSTEM_TENANT, component);

    // Assert
    verify(componentDescriptorRepository).existsById(isA(UUID.class));
    verify(component).getActions();
    verify(component).getClazz();
    verify(component).getClusteringMode();
    verify(component).getConfigurationDescriptor();
    verify(component).getConfigurationVersion();
    verify(component).getCreatedTime();
    verify(component, atLeast(1)).getId();
    verify(component).getName();
    verify(component).getScope();
    verify(component).getType();
    verify(component).isHasQueueName();
    verify(componentDescriptorEntity).setCreatedTime(eq(1L));
    verify(componentDescriptorEntity).setId(isA(UUID.class));
    verify(componentDescriptorEntity).setUuid(isA(UUID.class));
    verify(componentDescriptorEntity).setActions(eq("Actions"));
    verify(componentDescriptorEntity).setClazz(eq("Clazz"));
    verify(componentDescriptorEntity).setClusteringMode(eq(ComponentClusteringMode.USER_PREFERENCE));
    verify(componentDescriptorEntity).setConfigurationDescriptor(isA(JsonNode.class));
    verify(componentDescriptorEntity).setConfigurationVersion(eq(1));
    verify(componentDescriptorEntity).setHasQueueName(eq(true));
    verify(componentDescriptorEntity).setName(eq("Name"));
    verify(componentDescriptorEntity).setScope(eq(ComponentScope.SYSTEM));
    verify(componentDescriptorEntity).setType(eq(ComponentType.ENRICHMENT));
    verify(componentDescriptorEntity).toData();
    verify(componentDescriptorInsertRepository).saveOrUpdate(isA(ComponentDescriptorEntity.class));
    assertSame(componentDescriptor, actualSaveIfNotExistResult.get());
  }

  /**
   * Test
   * {@link JpaBaseComponentDescriptorDao#findById(TenantId, ComponentDescriptorId)}
   * with {@code tenantId}, {@code componentId}.
   * <p>
   * Method under test:
   * {@link JpaBaseComponentDescriptorDao#findById(TenantId, ComponentDescriptorId)}
   */
  @Test
  public void testFindByIdWithTenantIdComponentId() throws IOException {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);
    Optional<ComponentDescriptorEntity> ofResult = Optional.of(componentDescriptorEntity);
    when(componentDescriptorRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);

    // Act
    ComponentDescriptor actualFindByIdResult = jpaBaseComponentDescriptorDao.findById(ModelConstants.SYSTEM_TENANT,
        new ComponentDescriptorId(ModelConstants.NULL_UUID));

    // Assert
    verify(componentDescriptorRepository).findById(isA(UUID.class));
    JsonNode configurationDescriptor = actualFindByIdResult.getConfigurationDescriptor();
    Iterator<JsonNode> iteratorResult = configurationDescriptor.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(configurationDescriptor instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = configurationDescriptor.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    UUID uuidId = actualFindByIdResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("Actions", actualFindByIdResult.getActions());
    assertEquals("Clazz", actualFindByIdResult.getClazz());
    assertEquals("Name", actualFindByIdResult.getName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", configurationDescriptor.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(1, configurationDescriptor.size());
    assertEquals(1, actualFindByIdResult.getConfigurationVersion());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, actualFindByIdResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, configurationDescriptor.getNodeType());
    assertEquals(ComponentClusteringMode.USER_PREFERENCE, actualFindByIdResult.getClusteringMode());
    assertEquals(ComponentScope.SYSTEM, actualFindByIdResult.getScope());
    assertEquals(ComponentType.ENRICHMENT, actualFindByIdResult.getType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(configurationDescriptor.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(configurationDescriptor.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(configurationDescriptor.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(configurationDescriptor.isBinary());
    assertFalse(configurationDescriptor.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(configurationDescriptor.isDouble());
    assertFalse(configurationDescriptor.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(configurationDescriptor.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(configurationDescriptor.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(configurationDescriptor.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(configurationDescriptor.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(configurationDescriptor.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(configurationDescriptor.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(configurationDescriptor.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(configurationDescriptor.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(configurationDescriptor.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(configurationDescriptor.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(configurationDescriptor.isTextual());
    assertFalse(configurationDescriptor.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(configurationDescriptor.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(configurationDescriptor.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(actualFindByIdResult.isHasQueueName());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(uuidId, actualFindByIdResult.getId().getId());
  }

  /**
   * Test
   * {@link JpaBaseComponentDescriptorDao#findById(TenantId, ComponentDescriptorId)}
   * with {@code tenantId}, {@code componentId}.
   * <ul>
   *   <li>Then return {@link ComponentDescriptor#ComponentDescriptor()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaBaseComponentDescriptorDao#findById(TenantId, ComponentDescriptorId)}
   */
  @Test
  public void testFindByIdWithTenantIdComponentId_thenReturnComponentDescriptor() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = mock(ComponentDescriptorEntity.class);
    ComponentDescriptor componentDescriptor = new ComponentDescriptor();
    when(componentDescriptorEntity.toData()).thenReturn(componentDescriptor);
    doNothing().when(componentDescriptorEntity).setCreatedTime(anyLong());
    doNothing().when(componentDescriptorEntity).setId(Mockito.<UUID>any());
    doNothing().when(componentDescriptorEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(componentDescriptorEntity).setActions(Mockito.<String>any());
    doNothing().when(componentDescriptorEntity).setClazz(Mockito.<String>any());
    doNothing().when(componentDescriptorEntity).setClusteringMode(Mockito.<ComponentClusteringMode>any());
    doNothing().when(componentDescriptorEntity).setConfigurationDescriptor(Mockito.<JsonNode>any());
    doNothing().when(componentDescriptorEntity).setConfigurationVersion(anyInt());
    doNothing().when(componentDescriptorEntity).setHasQueueName(anyBoolean());
    doNothing().when(componentDescriptorEntity).setName(Mockito.<String>any());
    doNothing().when(componentDescriptorEntity).setScope(Mockito.<ComponentScope>any());
    doNothing().when(componentDescriptorEntity).setType(Mockito.<ComponentType>any());
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);
    Optional<ComponentDescriptorEntity> ofResult = Optional.of(componentDescriptorEntity);
    when(componentDescriptorRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);

    // Act
    ComponentDescriptor actualFindByIdResult = jpaBaseComponentDescriptorDao.findById(ModelConstants.SYSTEM_TENANT,
        new ComponentDescriptorId(ModelConstants.NULL_UUID));

    // Assert
    verify(componentDescriptorRepository).findById(isA(UUID.class));
    verify(componentDescriptorEntity).setCreatedTime(eq(1L));
    verify(componentDescriptorEntity).setId(isA(UUID.class));
    verify(componentDescriptorEntity).setUuid(isA(UUID.class));
    verify(componentDescriptorEntity).setActions(eq("Actions"));
    verify(componentDescriptorEntity).setClazz(eq("Clazz"));
    verify(componentDescriptorEntity).setClusteringMode(eq(ComponentClusteringMode.USER_PREFERENCE));
    verify(componentDescriptorEntity).setConfigurationDescriptor(isA(JsonNode.class));
    verify(componentDescriptorEntity).setConfigurationVersion(eq(1));
    verify(componentDescriptorEntity).setHasQueueName(eq(true));
    verify(componentDescriptorEntity).setName(eq("Name"));
    verify(componentDescriptorEntity).setScope(eq(ComponentScope.SYSTEM));
    verify(componentDescriptorEntity).setType(eq(ComponentType.ENRICHMENT));
    verify(componentDescriptorEntity).toData();
    assertSame(componentDescriptor, actualFindByIdResult);
  }

  /**
   * Test
   * {@link JpaBaseComponentDescriptorDao#findById(TenantId, ComponentDescriptorId)}
   * with {@code tenantId}, {@code componentId}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaBaseComponentDescriptorDao#findById(TenantId, ComponentDescriptorId)}
   */
  @Test
  public void testFindByIdWithTenantIdComponentId_thenReturnNull() {
    // Arrange
    Optional<ComponentDescriptorEntity> emptyResult = Optional.empty();
    when(componentDescriptorRepository.findById(Mockito.<UUID>any())).thenReturn(emptyResult);

    // Act
    ComponentDescriptor actualFindByIdResult = jpaBaseComponentDescriptorDao.findById(ModelConstants.SYSTEM_TENANT,
        new ComponentDescriptorId(ModelConstants.NULL_UUID));

    // Assert
    verify(componentDescriptorRepository).findById(isA(UUID.class));
    assertNull(actualFindByIdResult);
  }

  /**
   * Test {@link JpaBaseComponentDescriptorDao#findByClazz(TenantId, String)}.
   * <ul>
   *   <li>Then ConfigurationDescriptor iterator next return
   * {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaBaseComponentDescriptorDao#findByClazz(TenantId, String)}
   */
  @Test
  public void testFindByClazz_thenConfigurationDescriptorIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);
    when(componentDescriptorRepository.findByClazz(Mockito.<String>any())).thenReturn(componentDescriptorEntity);

    // Act
    ComponentDescriptor actualFindByClazzResult = jpaBaseComponentDescriptorDao
        .findByClazz(ModelConstants.SYSTEM_TENANT, "Clazz");

    // Assert
    verify(componentDescriptorRepository).findByClazz(eq("Clazz"));
    JsonNode configurationDescriptor = actualFindByClazzResult.getConfigurationDescriptor();
    Iterator<JsonNode> iteratorResult = configurationDescriptor.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(configurationDescriptor instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = configurationDescriptor.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    UUID uuidId = actualFindByClazzResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("Actions", actualFindByClazzResult.getActions());
    assertEquals("Clazz", actualFindByClazzResult.getClazz());
    assertEquals("Name", actualFindByClazzResult.getName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", configurationDescriptor.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(1, configurationDescriptor.size());
    assertEquals(1, actualFindByClazzResult.getConfigurationVersion());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, actualFindByClazzResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, configurationDescriptor.getNodeType());
    assertEquals(ComponentClusteringMode.USER_PREFERENCE, actualFindByClazzResult.getClusteringMode());
    assertEquals(ComponentScope.SYSTEM, actualFindByClazzResult.getScope());
    assertEquals(ComponentType.ENRICHMENT, actualFindByClazzResult.getType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(configurationDescriptor.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(configurationDescriptor.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(configurationDescriptor.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(configurationDescriptor.isBinary());
    assertFalse(configurationDescriptor.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(configurationDescriptor.isDouble());
    assertFalse(configurationDescriptor.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(configurationDescriptor.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(configurationDescriptor.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(configurationDescriptor.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(configurationDescriptor.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(configurationDescriptor.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(configurationDescriptor.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(configurationDescriptor.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(configurationDescriptor.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(configurationDescriptor.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(configurationDescriptor.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(configurationDescriptor.isTextual());
    assertFalse(configurationDescriptor.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(configurationDescriptor.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(configurationDescriptor.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(actualFindByClazzResult.isHasQueueName());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(uuidId, actualFindByClazzResult.getId().getId());
  }

  /**
   * Test {@link JpaBaseComponentDescriptorDao#findByClazz(TenantId, String)}.
   * <ul>
   *   <li>Then return {@link ComponentDescriptor#ComponentDescriptor()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaBaseComponentDescriptorDao#findByClazz(TenantId, String)}
   */
  @Test
  public void testFindByClazz_thenReturnComponentDescriptor() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = mock(ComponentDescriptorEntity.class);
    ComponentDescriptor componentDescriptor = new ComponentDescriptor();
    when(componentDescriptorEntity.toData()).thenReturn(componentDescriptor);
    doNothing().when(componentDescriptorEntity).setCreatedTime(anyLong());
    doNothing().when(componentDescriptorEntity).setId(Mockito.<UUID>any());
    doNothing().when(componentDescriptorEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(componentDescriptorEntity).setActions(Mockito.<String>any());
    doNothing().when(componentDescriptorEntity).setClazz(Mockito.<String>any());
    doNothing().when(componentDescriptorEntity).setClusteringMode(Mockito.<ComponentClusteringMode>any());
    doNothing().when(componentDescriptorEntity).setConfigurationDescriptor(Mockito.<JsonNode>any());
    doNothing().when(componentDescriptorEntity).setConfigurationVersion(anyInt());
    doNothing().when(componentDescriptorEntity).setHasQueueName(anyBoolean());
    doNothing().when(componentDescriptorEntity).setName(Mockito.<String>any());
    doNothing().when(componentDescriptorEntity).setScope(Mockito.<ComponentScope>any());
    doNothing().when(componentDescriptorEntity).setType(Mockito.<ComponentType>any());
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);
    when(componentDescriptorRepository.findByClazz(Mockito.<String>any())).thenReturn(componentDescriptorEntity);

    // Act
    ComponentDescriptor actualFindByClazzResult = jpaBaseComponentDescriptorDao
        .findByClazz(ModelConstants.SYSTEM_TENANT, "Clazz");

    // Assert
    verify(componentDescriptorEntity).setCreatedTime(eq(1L));
    verify(componentDescriptorEntity).setId(isA(UUID.class));
    verify(componentDescriptorEntity).setUuid(isA(UUID.class));
    verify(componentDescriptorEntity).setActions(eq("Actions"));
    verify(componentDescriptorEntity).setClazz(eq("Clazz"));
    verify(componentDescriptorEntity).setClusteringMode(eq(ComponentClusteringMode.USER_PREFERENCE));
    verify(componentDescriptorEntity).setConfigurationDescriptor(isA(JsonNode.class));
    verify(componentDescriptorEntity).setConfigurationVersion(eq(1));
    verify(componentDescriptorEntity).setHasQueueName(eq(true));
    verify(componentDescriptorEntity).setName(eq("Name"));
    verify(componentDescriptorEntity).setScope(eq(ComponentScope.SYSTEM));
    verify(componentDescriptorEntity).setType(eq(ComponentType.ENRICHMENT));
    verify(componentDescriptorEntity).toData();
    verify(componentDescriptorRepository).findByClazz(eq("Clazz"));
    assertSame(componentDescriptor, actualFindByClazzResult);
  }

  /**
   * Test
   * {@link JpaBaseComponentDescriptorDao#findByTypeAndPageLink(TenantId, ComponentType, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaBaseComponentDescriptorDao#findByTypeAndPageLink(TenantId, ComponentType, PageLink)}
   */
  @Test
  public void testFindByTypeAndPageLink() throws IOException {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<ComponentDescriptorEntity> content = new ArrayList<>();
    content.add(componentDescriptorEntity);
    PageImpl<ComponentDescriptorEntity> pageImpl = new PageImpl<>(content);
    when(componentDescriptorRepository.findByType(Mockito.<ComponentType>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<ComponentDescriptor> actualFindByTypeAndPageLinkResult = jpaBaseComponentDescriptorDao
        .findByTypeAndPageLink(ModelConstants.SYSTEM_TENANT, ComponentType.ENRICHMENT,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(componentDescriptorRepository).findByType(eq(ComponentType.ENRICHMENT), isNull(), isA(Pageable.class));
    List<ComponentDescriptor> data = actualFindByTypeAndPageLinkResult.getData();
    assertEquals(1, data.size());
    ComponentDescriptor getResult = data.get(0);
    JsonNode configurationDescriptor = getResult.getConfigurationDescriptor();
    Iterator<JsonNode> iteratorResult = configurationDescriptor.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(configurationDescriptor instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = configurationDescriptor.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    UUID uuidId = getResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("Actions", getResult.getActions());
    assertEquals("Clazz", getResult.getClazz());
    assertEquals("Name", getResult.getName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", configurationDescriptor.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(1, configurationDescriptor.size());
    assertEquals(1, getResult.getConfigurationVersion());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, configurationDescriptor.getNodeType());
    assertEquals(ComponentClusteringMode.USER_PREFERENCE, getResult.getClusteringMode());
    assertEquals(ComponentScope.SYSTEM, getResult.getScope());
    assertEquals(ComponentType.ENRICHMENT, getResult.getType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(configurationDescriptor.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(configurationDescriptor.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(configurationDescriptor.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(configurationDescriptor.isBinary());
    assertFalse(configurationDescriptor.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(configurationDescriptor.isDouble());
    assertFalse(configurationDescriptor.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(configurationDescriptor.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(configurationDescriptor.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(configurationDescriptor.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(configurationDescriptor.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(configurationDescriptor.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(configurationDescriptor.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(configurationDescriptor.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(configurationDescriptor.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(configurationDescriptor.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(configurationDescriptor.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(configurationDescriptor.isTextual());
    assertFalse(configurationDescriptor.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(configurationDescriptor.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(configurationDescriptor.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(getResult.isHasQueueName());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(uuidId, getResult.getId().getId());
  }

  /**
   * Test
   * {@link JpaBaseComponentDescriptorDao#findByTypeAndPageLink(TenantId, ComponentType, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaBaseComponentDescriptorDao#findByTypeAndPageLink(TenantId, ComponentType, PageLink)}
   */
  @Test
  public void testFindByTypeAndPageLink_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(componentDescriptorRepository.findByType(Mockito.<ComponentType>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<ComponentDescriptor> actualFindByTypeAndPageLinkResult = jpaBaseComponentDescriptorDao
        .findByTypeAndPageLink(ModelConstants.SYSTEM_TENANT, ComponentType.ENRICHMENT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(componentDescriptorRepository).findByType(eq(ComponentType.ENRICHMENT), eq("Text Search"),
        isA(Pageable.class));
    assertEquals(0L, actualFindByTypeAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByTypeAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTypeAndPageLinkResult.hasNext());
    assertTrue(actualFindByTypeAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaBaseComponentDescriptorDao#findByTypeAndPageLink(TenantId, ComponentType, PageLink)}.
   * <ul>
   *   <li>Then return Data first is
   * {@link ComponentDescriptor#ComponentDescriptor()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaBaseComponentDescriptorDao#findByTypeAndPageLink(TenantId, ComponentType, PageLink)}
   */
  @Test
  public void testFindByTypeAndPageLink_thenReturnDataFirstIsComponentDescriptor() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = mock(ComponentDescriptorEntity.class);
    ComponentDescriptor componentDescriptor = new ComponentDescriptor();
    when(componentDescriptorEntity.toData()).thenReturn(componentDescriptor);
    doNothing().when(componentDescriptorEntity).setCreatedTime(anyLong());
    doNothing().when(componentDescriptorEntity).setId(Mockito.<UUID>any());
    doNothing().when(componentDescriptorEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(componentDescriptorEntity).setActions(Mockito.<String>any());
    doNothing().when(componentDescriptorEntity).setClazz(Mockito.<String>any());
    doNothing().when(componentDescriptorEntity).setClusteringMode(Mockito.<ComponentClusteringMode>any());
    doNothing().when(componentDescriptorEntity).setConfigurationDescriptor(Mockito.<JsonNode>any());
    doNothing().when(componentDescriptorEntity).setConfigurationVersion(anyInt());
    doNothing().when(componentDescriptorEntity).setHasQueueName(anyBoolean());
    doNothing().when(componentDescriptorEntity).setName(Mockito.<String>any());
    doNothing().when(componentDescriptorEntity).setScope(Mockito.<ComponentScope>any());
    doNothing().when(componentDescriptorEntity).setType(Mockito.<ComponentType>any());
    componentDescriptorEntity.setActions("42");
    componentDescriptorEntity.setClazz("42");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.SINGLETON);
    componentDescriptorEntity.setConfigurationDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(-1);
    componentDescriptorEntity.setCreatedTime(-1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("42");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.TRANSFORMATION);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<ComponentDescriptorEntity> content = new ArrayList<>();
    content.add(componentDescriptorEntity);
    PageImpl<ComponentDescriptorEntity> pageImpl = new PageImpl<>(content);
    when(componentDescriptorRepository.findByType(Mockito.<ComponentType>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<ComponentDescriptor> actualFindByTypeAndPageLinkResult = jpaBaseComponentDescriptorDao
        .findByTypeAndPageLink(ModelConstants.SYSTEM_TENANT, ComponentType.ENRICHMENT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(componentDescriptorEntity).setCreatedTime(eq(-1L));
    verify(componentDescriptorEntity).setId(isA(UUID.class));
    verify(componentDescriptorEntity).setUuid(isA(UUID.class));
    verify(componentDescriptorEntity).setActions(eq("42"));
    verify(componentDescriptorEntity).setClazz(eq("42"));
    verify(componentDescriptorEntity).setClusteringMode(eq(ComponentClusteringMode.SINGLETON));
    verify(componentDescriptorEntity).setConfigurationDescriptor(isA(JsonNode.class));
    verify(componentDescriptorEntity).setConfigurationVersion(eq(-1));
    verify(componentDescriptorEntity).setHasQueueName(eq(true));
    verify(componentDescriptorEntity).setName(eq("42"));
    verify(componentDescriptorEntity).setScope(eq(ComponentScope.SYSTEM));
    verify(componentDescriptorEntity).setType(eq(ComponentType.TRANSFORMATION));
    verify(componentDescriptorEntity).toData();
    verify(componentDescriptorRepository).findByType(eq(ComponentType.ENRICHMENT), eq("Text Search"),
        isA(Pageable.class));
    List<ComponentDescriptor> data = actualFindByTypeAndPageLinkResult.getData();
    assertEquals(1, data.size());
    assertSame(componentDescriptor, data.get(0));
  }

  /**
   * Test
   * {@link JpaBaseComponentDescriptorDao#findByTypeAndPageLink(TenantId, ComponentType, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaBaseComponentDescriptorDao#findByTypeAndPageLink(TenantId, ComponentType, PageLink)}
   */
  @Test
  public void testFindByTypeAndPageLink_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(componentDescriptorRepository.findByType(Mockito.<ComponentType>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<ComponentDescriptor> actualFindByTypeAndPageLinkResult = jpaBaseComponentDescriptorDao
        .findByTypeAndPageLink(ModelConstants.SYSTEM_TENANT, ComponentType.ENRICHMENT,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(componentDescriptorRepository).findByType(eq(ComponentType.ENRICHMENT), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTypeAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByTypeAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTypeAndPageLinkResult.hasNext());
    assertTrue(actualFindByTypeAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaBaseComponentDescriptorDao#findByScopeAndTypeAndPageLink(TenantId, ComponentScope, ComponentType, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaBaseComponentDescriptorDao#findByScopeAndTypeAndPageLink(TenantId, ComponentScope, ComponentType, PageLink)}
   */
  @Test
  public void testFindByScopeAndTypeAndPageLink() throws IOException {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<ComponentDescriptorEntity> content = new ArrayList<>();
    content.add(componentDescriptorEntity);
    PageImpl<ComponentDescriptorEntity> pageImpl = new PageImpl<>(content);
    when(componentDescriptorRepository.findByScopeAndType(Mockito.<ComponentType>any(), Mockito.<ComponentScope>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<ComponentDescriptor> actualFindByScopeAndTypeAndPageLinkResult = jpaBaseComponentDescriptorDao
        .findByScopeAndTypeAndPageLink(ModelConstants.SYSTEM_TENANT, ComponentScope.SYSTEM, ComponentType.ENRICHMENT,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(componentDescriptorRepository).findByScopeAndType(eq(ComponentType.ENRICHMENT), eq(ComponentScope.SYSTEM),
        isNull(), isA(Pageable.class));
    List<ComponentDescriptor> data = actualFindByScopeAndTypeAndPageLinkResult.getData();
    assertEquals(1, data.size());
    ComponentDescriptor getResult = data.get(0);
    JsonNode configurationDescriptor = getResult.getConfigurationDescriptor();
    Iterator<JsonNode> iteratorResult = configurationDescriptor.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(configurationDescriptor instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = configurationDescriptor.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    UUID uuidId = getResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("Actions", getResult.getActions());
    assertEquals("Clazz", getResult.getClazz());
    assertEquals("Name", getResult.getName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", configurationDescriptor.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(1, configurationDescriptor.size());
    assertEquals(1, getResult.getConfigurationVersion());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, configurationDescriptor.getNodeType());
    assertEquals(ComponentClusteringMode.USER_PREFERENCE, getResult.getClusteringMode());
    assertEquals(ComponentScope.SYSTEM, getResult.getScope());
    assertEquals(ComponentType.ENRICHMENT, getResult.getType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(configurationDescriptor.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(configurationDescriptor.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(configurationDescriptor.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(configurationDescriptor.isBinary());
    assertFalse(configurationDescriptor.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(configurationDescriptor.isDouble());
    assertFalse(configurationDescriptor.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(configurationDescriptor.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(configurationDescriptor.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(configurationDescriptor.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(configurationDescriptor.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(configurationDescriptor.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(configurationDescriptor.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(configurationDescriptor.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(configurationDescriptor.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(configurationDescriptor.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(configurationDescriptor.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(configurationDescriptor.isTextual());
    assertFalse(configurationDescriptor.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(configurationDescriptor.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(configurationDescriptor.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(getResult.isHasQueueName());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(uuidId, getResult.getId().getId());
  }

  /**
   * Test
   * {@link JpaBaseComponentDescriptorDao#findByScopeAndTypeAndPageLink(TenantId, ComponentScope, ComponentType, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaBaseComponentDescriptorDao#findByScopeAndTypeAndPageLink(TenantId, ComponentScope, ComponentType, PageLink)}
   */
  @Test
  public void testFindByScopeAndTypeAndPageLink_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(componentDescriptorRepository.findByScopeAndType(Mockito.<ComponentType>any(), Mockito.<ComponentScope>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<ComponentDescriptor> actualFindByScopeAndTypeAndPageLinkResult = jpaBaseComponentDescriptorDao
        .findByScopeAndTypeAndPageLink(ModelConstants.SYSTEM_TENANT, ComponentScope.SYSTEM, ComponentType.ENRICHMENT,
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(componentDescriptorRepository).findByScopeAndType(eq(ComponentType.ENRICHMENT), eq(ComponentScope.SYSTEM),
        eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByScopeAndTypeAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByScopeAndTypeAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByScopeAndTypeAndPageLinkResult.hasNext());
    assertTrue(actualFindByScopeAndTypeAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaBaseComponentDescriptorDao#findByScopeAndTypeAndPageLink(TenantId, ComponentScope, ComponentType, PageLink)}.
   * <ul>
   *   <li>Then return Data first is
   * {@link ComponentDescriptor#ComponentDescriptor()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaBaseComponentDescriptorDao#findByScopeAndTypeAndPageLink(TenantId, ComponentScope, ComponentType, PageLink)}
   */
  @Test
  public void testFindByScopeAndTypeAndPageLink_thenReturnDataFirstIsComponentDescriptor() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = mock(ComponentDescriptorEntity.class);
    ComponentDescriptor componentDescriptor = new ComponentDescriptor();
    when(componentDescriptorEntity.toData()).thenReturn(componentDescriptor);
    doNothing().when(componentDescriptorEntity).setCreatedTime(anyLong());
    doNothing().when(componentDescriptorEntity).setId(Mockito.<UUID>any());
    doNothing().when(componentDescriptorEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(componentDescriptorEntity).setActions(Mockito.<String>any());
    doNothing().when(componentDescriptorEntity).setClazz(Mockito.<String>any());
    doNothing().when(componentDescriptorEntity).setClusteringMode(Mockito.<ComponentClusteringMode>any());
    doNothing().when(componentDescriptorEntity).setConfigurationDescriptor(Mockito.<JsonNode>any());
    doNothing().when(componentDescriptorEntity).setConfigurationVersion(anyInt());
    doNothing().when(componentDescriptorEntity).setHasQueueName(anyBoolean());
    doNothing().when(componentDescriptorEntity).setName(Mockito.<String>any());
    doNothing().when(componentDescriptorEntity).setScope(Mockito.<ComponentScope>any());
    doNothing().when(componentDescriptorEntity).setType(Mockito.<ComponentType>any());
    componentDescriptorEntity.setActions("42");
    componentDescriptorEntity.setClazz("42");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.SINGLETON);
    componentDescriptorEntity.setConfigurationDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(-1);
    componentDescriptorEntity.setCreatedTime(-1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("42");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.TRANSFORMATION);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<ComponentDescriptorEntity> content = new ArrayList<>();
    content.add(componentDescriptorEntity);
    PageImpl<ComponentDescriptorEntity> pageImpl = new PageImpl<>(content);
    when(componentDescriptorRepository.findByScopeAndType(Mockito.<ComponentType>any(), Mockito.<ComponentScope>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<ComponentDescriptor> actualFindByScopeAndTypeAndPageLinkResult = jpaBaseComponentDescriptorDao
        .findByScopeAndTypeAndPageLink(ModelConstants.SYSTEM_TENANT, ComponentScope.SYSTEM, ComponentType.ENRICHMENT,
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(componentDescriptorEntity).setCreatedTime(eq(-1L));
    verify(componentDescriptorEntity).setId(isA(UUID.class));
    verify(componentDescriptorEntity).setUuid(isA(UUID.class));
    verify(componentDescriptorEntity).setActions(eq("42"));
    verify(componentDescriptorEntity).setClazz(eq("42"));
    verify(componentDescriptorEntity).setClusteringMode(eq(ComponentClusteringMode.SINGLETON));
    verify(componentDescriptorEntity).setConfigurationDescriptor(isA(JsonNode.class));
    verify(componentDescriptorEntity).setConfigurationVersion(eq(-1));
    verify(componentDescriptorEntity).setHasQueueName(eq(true));
    verify(componentDescriptorEntity).setName(eq("42"));
    verify(componentDescriptorEntity).setScope(eq(ComponentScope.SYSTEM));
    verify(componentDescriptorEntity).setType(eq(ComponentType.TRANSFORMATION));
    verify(componentDescriptorEntity).toData();
    verify(componentDescriptorRepository).findByScopeAndType(eq(ComponentType.ENRICHMENT), eq(ComponentScope.SYSTEM),
        eq("Text Search"), isA(Pageable.class));
    List<ComponentDescriptor> data = actualFindByScopeAndTypeAndPageLinkResult.getData();
    assertEquals(1, data.size());
    assertSame(componentDescriptor, data.get(0));
  }

  /**
   * Test
   * {@link JpaBaseComponentDescriptorDao#findByScopeAndTypeAndPageLink(TenantId, ComponentScope, ComponentType, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaBaseComponentDescriptorDao#findByScopeAndTypeAndPageLink(TenantId, ComponentScope, ComponentType, PageLink)}
   */
  @Test
  public void testFindByScopeAndTypeAndPageLink_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(componentDescriptorRepository.findByScopeAndType(Mockito.<ComponentType>any(), Mockito.<ComponentScope>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<ComponentDescriptor> actualFindByScopeAndTypeAndPageLinkResult = jpaBaseComponentDescriptorDao
        .findByScopeAndTypeAndPageLink(ModelConstants.SYSTEM_TENANT, ComponentScope.SYSTEM, ComponentType.ENRICHMENT,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(componentDescriptorRepository).findByScopeAndType(eq(ComponentType.ENRICHMENT), eq(ComponentScope.SYSTEM),
        isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByScopeAndTypeAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByScopeAndTypeAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByScopeAndTypeAndPageLinkResult.hasNext());
    assertTrue(actualFindByScopeAndTypeAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaBaseComponentDescriptorDao#deleteById(TenantId, ComponentDescriptorId)}.
   * <ul>
   *   <li>When {@link ComponentDescriptorId#ComponentDescriptorId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link JpaRepository#flush()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaBaseComponentDescriptorDao#deleteById(TenantId, ComponentDescriptorId)}
   */
  @Test
  public void testDeleteById_whenComponentDescriptorIdWithIdIsNull_uuid_thenCallsFlush() {
    // Arrange
    doNothing().when(componentDescriptorRepository).flush();
    doNothing().when(componentDescriptorRepository).deleteById(Mockito.<UUID>any());

    // Act
    jpaBaseComponentDescriptorDao.deleteById(ModelConstants.SYSTEM_TENANT,
        new ComponentDescriptorId(ModelConstants.NULL_UUID));

    // Assert that nothing has changed
    verify(componentDescriptorRepository).flush();
    verify(componentDescriptorRepository).deleteById(isA(UUID.class));
  }

  /**
   * Test {@link JpaBaseComponentDescriptorDao#deleteByClazz(TenantId, String)}.
   * <p>
   * Method under test:
   * {@link JpaBaseComponentDescriptorDao#deleteByClazz(TenantId, String)}
   */
  @Test
  public void testDeleteByClazz() {
    // Arrange
    doNothing().when(componentDescriptorRepository).deleteByClazz(Mockito.<String>any());

    // Act
    jpaBaseComponentDescriptorDao.deleteByClazz(ModelConstants.SYSTEM_TENANT, "Clazz");

    // Assert that nothing has changed
    verify(componentDescriptorRepository).deleteByClazz(eq("Clazz"));
  }
}
