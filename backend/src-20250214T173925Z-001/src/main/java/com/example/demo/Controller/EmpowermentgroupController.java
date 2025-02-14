package com.example.demo.Controller;

import java.util.List;
import com.example.demo.DTO.EmpowermentgroupDTO;
import com.example.demo.Service.EmpowermentgroupService;
import com.example.demo.pojo.Empowermentgroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/empowermentgroup")
@CrossOrigin(origins = "http://localhost:3000") // Allow frontend access
public class EmpowermentgroupController {

    @Autowired
    private EmpowermentgroupService empowermentgroupService;

    // Fetch all Empowerment Groups
    @GetMapping("/display")
    public List<EmpowermentgroupDTO> displayEmpowermentGroups() {
        return empowermentgroupService.displayinfo().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Insert an Empowerment Group
    @PostMapping()
    public String insertEmpowermentGroup(@RequestBody EmpowermentgroupDTO dto) {
        Empowermentgroup empowermentgroup = convertToEntity(dto);
        return empowermentgroupService.saveEmpGrp(empowermentgroup);
    }

    // Delete an Empowerment Group
    @DeleteMapping("/{id}")
    public String deleteEmpowermentGroup(@PathVariable Long id) {
        return empowermentgroupService.deleteEmpGrp(id);
    }

    // Update an Empowerment Group
    @PutMapping("/{id}")
    public String updateEmpowermentGroup(@PathVariable Long id, @RequestBody EmpowermentgroupDTO dto) {
        Empowermentgroup empowermentgroup = convertToEntity(dto);
        return empowermentgroupService.updateEmpGrp(id, empowermentgroup);
    }

    // Convert `Empowermentgroup` to `EmpowermentgroupDTO`
    private EmpowermentgroupDTO convertToDTO(Empowermentgroup empowermentgroup) {
        return new EmpowermentgroupDTO(
                empowermentgroup.getEmp_grp_id(),
                empowermentgroup.getGrp_name(),
                empowermentgroup.getCreated_at(),
                empowermentgroup.getUpdated_at(),
                empowermentgroup.getDescription(),
                empowermentgroup.getUsers()
        );
    }

    // Convert `EmpowermentgroupDTO` to `Empowermentgroup`
    private Empowermentgroup convertToEntity(EmpowermentgroupDTO dto) {
        Empowermentgroup empowermentgroup = new Empowermentgroup();
        empowermentgroup.setEmp_grp_id(dto.getEmp_grp_id());
        empowermentgroup.setGrp_name(dto.getGrp_name());
        empowermentgroup.setCreated_at(dto.getCreated_at());
        empowermentgroup.setUpdated_at(dto.getUpdated_at());
        empowermentgroup.setDescription(dto.getDescription());
        empowermentgroup.setUsers(dto.getUsers());
        return empowermentgroup;
    }
	
	
}
