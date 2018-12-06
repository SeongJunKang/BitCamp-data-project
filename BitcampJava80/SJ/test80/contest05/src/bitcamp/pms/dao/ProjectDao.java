package bitcamp.pms.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import bitcamp.pms.annotation.Component;
import bitcamp.pms.domain.Project;

@Component 
public class ProjectDao {
  static final String filename = "project.data";
  
  public ArrayList<Project> selectList() {
    
    ArrayList<Project> projects = new ArrayList<>();
    try{
    FileReader in0 = new FileReader(filename);
    BufferedReader in1 = new BufferedReader(in0);

    String line;
    String[] values;
    Project project;

    while ((line = in1.readLine()) != null) {
      values = line.split(",");

      project = new Project();

      project.setTitle(values[0]);
      project.setStartDate(Date.valueOf(values[1]));
      project.setEndDate(Date.valueOf(values[2]));
      project.setDescription(values[3]);
      project.setState(Integer.parseInt(values[4]));

      projects.add(project);

    }

    in1.close();
    in0.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return projects;

  }

  public void insert(Project project) {
    try {
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename,true)));
      out.println(project);
      out.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void save(List<Project> projects) {
    try {
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
      for (Project project : projects)
        out.println(project);
      out.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public Project selectOne(int no) {
    List<Project> projects = selectList();
    return projects.get(no);
  }
  public void delete (int no) {
    List<Project> projects = selectList();
    projects.remove(no);
    save(projects);
  }
  public void update (int no,Project project) {
    List<Project> projects = selectList();
    projects.set(no,project);
    save(projects);
  }
}
