package com.jie.demo.job.service;

import org.springframework.stereotype.Service;

@Service
public class FileService {

//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//
//	public List<FileCustom> fetchUnBackupFiles(String type, int count) {
//		String sql = "select * from t_file where type = ? limit ?";
//
//		return jdbcTemplate.query(sql, new Object[]{type, count}, BeanPropertyRowMapper.newInstance(FileCustom.class));
//	}
//
//	public void backupFiles(List<FileCustom> files) {
//		String sql = "update t_file set backup = ? where id = ?";
//		files.forEach(item -> {
//			jdbcTemplate.update(sql, true, item.getId());
//
//			System.out.printf("备份文件: name=%s  type=%s \n" + item.getName(), item.getType());
//		});
//	}
}
