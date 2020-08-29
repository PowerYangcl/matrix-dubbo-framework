package com.matrix.sxt.e12;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSONObject;

// 模拟活跃用户前5名
public class TaskUserDemoTop5 implements Callable<JSONObject> {
	private CountDownLatch countDownLatch;

	public TaskUserDemoTop5(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	@Override
	public JSONObject call() throws Exception {
		JSONObject result = new JSONObject();
		try { TimeUnit.SECONDS.sleep(15); } catch (InterruptedException e) { e.printStackTrace(); }  // 模拟查库耗时3秒
		result.put("data", "活跃用户前5名接口查库耗时15秒");
		this.countDownLatch.countDown(); // 计数器减一
		return result;
	}

}