import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

import com.felipeguimaraes.codechallenge.api.CodeChallengeApplication;
import com.felipeguimaraes.codechallenge.api.resource.PdvResource;

@Profile(value = "test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CodeChallengeApplication.class)
public class CodeChallengeApplicationTest {

	@Autowired
	private PdvResource pdvResource;

	@Test
	public void contexLoads() throws Exception {
		assertThat(pdvResource).isNotNull();
	}
}
