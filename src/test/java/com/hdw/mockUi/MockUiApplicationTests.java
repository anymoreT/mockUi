package com.hdw.mockUi;

import com.hdw.mockUi.utils.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockUiApplicationTests {

	@Test
	public void contextLoads() {
		FileUtils.getStreamFromFile("data/json.data");
	}

}

