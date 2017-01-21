package sec.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sec.project.domain.Link;

public interface LinkRepository extends JpaRepository<Link, Long> {

}
