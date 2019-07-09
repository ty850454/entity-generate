package ${package};

import ${entityPackage}.${entityName};
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ${comment!}
 * @author ${author!}
 */
public interface ${className} extends JpaRepository<${entityName}, ${keyType}> {

}